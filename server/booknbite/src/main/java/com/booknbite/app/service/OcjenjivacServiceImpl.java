package com.booknbite.app.service;

import com.booknbite.app.model.CodeGenerator;
import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.request.CreateGrupaRequest;
import com.booknbite.app.model.request.CreateJoinRequest;
import com.booknbite.app.model.request.CreateOcjenjivacRequest;
import com.booknbite.app.model.request.OcjenjivacBool;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class OcjenjivacServiceImpl implements OcjenjivacService {

    private final OcjenjivacRepository ocjenjivacRepository;
    private final GrupaRepository grupaRepository;

    @Autowired
    public OcjenjivacServiceImpl(OcjenjivacRepository ocjenjivacRepository, GrupaRepository grupaRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
        this.grupaRepository = grupaRepository;
    }

    //provjerava ako korisnik ima racun te ga proslijeduje na glavnu stranicu, ako nema racun onda ga preusmjeri na registraciju
    //na frontend vraca korisnikove podatke za personalizirano koristenje te true false vrijednost za provjeru ako postoji u bazi
    @Override
    public OcjenjivacBool retrieveOcjenjivac(OAuth2User token) {

        Optional<Ocjenjivac> login = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        OcjenjivacBool ocjenjivac = new OcjenjivacBool();

        ocjenjivac.setOcjenjivacId(token.getAttribute("sub"));
        ocjenjivac.setOcjenjivacIme(token.getAttribute("name"));
        ocjenjivac.setEmail(token.getAttribute("email"));

        ocjenjivac.setIsRegistered(login.isPresent());

        return ocjenjivac;
    }

    //prima podatke za registraciju te ih sprema u bazu
    @Override
    public Ocjenjivac addOcjenjivac(OAuth2User token, CreateOcjenjivacRequest ocjenjivacRequest) {

        Ocjenjivac ocjenjivac = new Ocjenjivac();
        ocjenjivac.setOcjenjivacId(token.getAttribute("sub"));
        ocjenjivac.setOcjenjivacIme(token.getAttribute("name"));
        ocjenjivac.setEmail(token.getAttribute("email"));
        ocjenjivac.setUsername(ocjenjivacRequest.getUsername());
        ocjenjivac.setFirstName(ocjenjivacRequest.getFirstName());
        ocjenjivac.setLastName(ocjenjivacRequest.getLastName());

        ocjenjivacRepository.save(ocjenjivac);
        return ocjenjivac;
    }

    //korisnik se pozicionira u novo kreiranu grupu i grupi se dodjeljuje kod
    //na frontend se vracaju osnovni podaci o grupi (kod, kategorija jela...)
    @Override
    public Grupa createGrupa(CreateGrupaRequest grupaRequest) {
        String kategorija = grupaRequest.getKategorijaGrupa();
        Grupa grupa = new Grupa();
        grupa.setKategorijaGrupa(kategorija);
        grupa.setGroupCode(CodeGenerator.generateGroupCode());

        /*
        if(kategorija.equals("brza-hrana")){

        }else if(kategorija.equals("obicni")){

        }else if(kategorija.equals("desert")){

        }else{

        }
        */
        return grupaRepository.save(grupa);
    }

    //korisnik se dodava u grupu pomocu koda koji je unesen, ocjenjivacService provjerava ako grupa s kodom postoji te ovisno o tome dodava korisnika
    @Override
    public boolean grupaExists(CreateJoinRequest joinRequest) {
        Optional<Grupa> grupa = grupaRepository.findByGroupCode(joinRequest.getGroupCode());
        return grupa.isPresent();
    }
}
