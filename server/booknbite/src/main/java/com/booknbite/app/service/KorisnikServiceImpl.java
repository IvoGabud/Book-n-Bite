package com.booknbite.app.service;

import com.booknbite.app.model.*;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.KorisnikRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.CreateGrupaRequest;
import com.booknbite.app.model.request.CreateJoinRequest;
import com.booknbite.app.model.request.CreateKorisnikRequest;
import com.booknbite.app.model.request.KorisnikBool;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final OcjenjivacRepository ocjenjivacRepository;
    private final GrupaRepository grupaRepository;
    private final RestoranRepository restoranRepository;
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, OcjenjivacRepository ocjenjivacRepository, GrupaRepository grupaRepository, RestoranRepository restoranRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
        this.grupaRepository = grupaRepository;
        this.restoranRepository = restoranRepository;
        this.korisnikRepository = korisnikRepository;
    }

    //provjerava ako korisnik ima racun te ga proslijeduje na glavnu stranicu, ako nema racun onda ga preusmjeri na registraciju
    //na frontend vraca korisnikove podatke za personalizirano koristenje te true false vrijednost za provjeru ako postoji u bazi
    @Override
    public KorisnikBool retrieveOcjenjivac(OAuth2User token) {

        Optional<Korisnik> login = korisnikRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        KorisnikBool korisnik = new KorisnikBool();

        Korisnik kor = new Korisnik();
        if(login.isPresent())
            kor = login.get();

        korisnik.setOcjenjivacId(token.getAttribute("sub"));
        korisnik.setOcjenjivacIme(token.getAttribute("name"));
        korisnik.setEmail(token.getAttribute("email"));

        if(kor instanceof Ocjenjivac)
            korisnik.setUserType(UserType.OCJENJIVAC);
        else if(kor instanceof Restoran) {
            korisnik.setUserType(UserType.RESTORAN);
            Optional<Restoran> restoranOptional = restoranRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

            Restoran restoran = new Restoran();
            if (restoranOptional.isPresent())
                restoran = restoranOptional.get();

            korisnik.setIsVerified(restoran.getIsVerified());
            korisnik.setIsFilled(restoran.getIsFilled());
        }
        else if(kor instanceof Administrator)
            korisnik.setUserType(UserType.ADMINISTRATOR);

        korisnik.setIsRegistered(login.isPresent());

        return korisnik;
    }

    //prima podatke za registraciju te ih sprema u bazu
    @Override
    public Korisnik addKorisnik(OAuth2User token, CreateKorisnikRequest korisnikRequest) {

        if(korisnikRequest.getUserType() == UserType.OCJENJIVAC){
            Ocjenjivac ocjenjivac = new Ocjenjivac();
            ocjenjivac.setKorisnikId(token.getAttribute("sub"));
            ocjenjivac.setKorisnickoIme(token.getAttribute("name"));
            ocjenjivac.setEmail(token.getAttribute("email"));
            ocjenjivac.setUsername(korisnikRequest.getUsername());
            ocjenjivac.setFirstName(korisnikRequest.getFirstName());
            ocjenjivac.setLastName(korisnikRequest.getLastName());
            ocjenjivac.setUserType(UserType.OCJENJIVAC);

            ocjenjivacRepository.save(ocjenjivac);
            return ocjenjivac;

        }else if(korisnikRequest.getUserType() == UserType.RESTORAN){
            Restoran restoran = new Restoran();
            restoran.setKorisnikId(token.getAttribute("sub"));
            restoran.setKorisnickoIme(token.getAttribute("name"));
            restoran.setEmail(token.getAttribute("email"));
            restoran.setUsername(korisnikRequest.getUsername());
            restoran.setFirstName(korisnikRequest.getFirstName());
            restoran.setLastName(korisnikRequest.getLastName());
            restoran.setUserType(UserType.RESTORAN);

            restoranRepository.save(restoran);
            return restoran;

        }else {
            throw new RuntimeException("Ne postoji zapis koji nije jedan od ocjenjivaca ili restorana!");
        }
    }

    //korisnik se pozicionira u novo kreiranu grupu i grupi se dodjeljuje kod
    //na frontend se vracaju osnovni podaci o grupi (kod, kategorija jela...)
    @Override
    public Grupa createGrupa(CreateGrupaRequest grupaRequest) {
        String kategorija = grupaRequest.getKategorijaGrupa();
        Grupa grupa = new Grupa();
        grupa.setGrupaKategorija(kategorija);
        grupa.setGrupaKod(CodeGenerator.generateGroupCode());

        return grupaRepository.save(grupa);
    }

    //korisnik se dodava u grupu pomocu koda koji je unesen, ocjenjivacService provjerava ako grupa s kodom postoji te ovisno o tome dodava korisnika
    @Override
    public boolean grupaExists(CreateJoinRequest joinRequest) {
        Optional<Grupa> grupa = grupaRepository.findByGrupaKod(joinRequest.getGroupCode());
        return grupa.isPresent();
    }
}
