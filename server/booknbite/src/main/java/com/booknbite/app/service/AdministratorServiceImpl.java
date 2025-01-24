package com.booknbite.app.service;

import com.booknbite.app.model.Korisnik;
import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.KorisnikRepository;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.RestoranShortDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    private final OcjenjivacRepository ocjenjivacRepository;
    private final RestoranRepository restoranRepository;
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public AdministratorServiceImpl(KorisnikRepository korisnikRepository, OcjenjivacRepository ocjenjivacRepository, RestoranRepository restoranRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
        this.restoranRepository = restoranRepository;
        this.korisnikRepository = korisnikRepository;
    }

    //vraca listu ocjenjivaca adminu
    @Override
    public List<Ocjenjivac> listaOcjenjivaca() {
        return ocjenjivacRepository.findAll();
    }

    //vraca listu restorana adminu
    @Override
    public List<RestoranShortDTO> listaRestorana() {
        List<Restoran> restorani = restoranRepository.findAll();

        List<RestoranShortDTO> listaRestorana = new ArrayList<>();
        for(Restoran restoran : restorani){
            RestoranShortDTO restoranShortDTO = new RestoranShortDTO();
            restoranShortDTO.setKorisnikId(restoran.getKorisnikId());
            restoranShortDTO.setNazivRestoran(restoran.getNazivRestoran());
            restoranShortDTO.setBlokiran(restoran.getBlokiran());
            listaRestorana.add(restoranShortDTO);
        }

        return listaRestorana;
    }

    //dohvaca listu restorana koje je potrebno verificirati
    @Override
    public List<Restoran> listaVerifikacija() {
        return restoranRepository.findAllByIsVerified(false);
    }

    //admin verificira restoran po idu korisnika
    @Override
    public String verificiraj(String id) {

        Optional<Restoran> restoranOptional = restoranRepository.findById(id);

        Restoran restoran;
        if(restoranOptional.isPresent())
            restoran = restoranOptional.get();
        else
            return "Verifikacija nije uspjela restoran sa id " + id + " ne postoji!";

        restoran.setIsVerified(true);
        restoranRepository.save(restoran);

        return "Restoran je verificiran.";
    }

    //brise korisnika (restoran ili ocjenjivac po idu)
    @Transactional
    @Override
    public String obrisiKorisnika(String id) {

        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(id);

        Korisnik korisnik;
        if (korisnikOptional.isPresent())
            korisnik = korisnikOptional.get();
        else
            return "Korisnik nije obrisan jer ne postoji u bazi.";

        korisnikRepository.removeByKorisnikId(id);

        return "Korisnik je uspješno uklonjen.";
    }

    //prikazuje stranicu ocjenjivaca
    @Override
    public Ocjenjivac prikaziOcjenjivaca(String id) {
        Optional<Ocjenjivac> ocjenjivacOptional = ocjenjivacRepository.findById(id);
        return ocjenjivacOptional.orElse(null);
    }

    //blokira racun korisnika (ocjenjivaca ili restorana po idu)
    @Override
    public String blokirajRacun(String id) {
        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(id);

        Korisnik korisnik;
        if(korisnikOptional.isPresent()){
            korisnik = korisnikOptional.get();

            if(korisnik instanceof Restoran restoran){
                restoran.setBlokiran(!restoran.getBlokiran());
                restoranRepository.save(restoran);
            }else if(korisnik instanceof Ocjenjivac ocjenjivac){
                ocjenjivac.setBlokiran(!ocjenjivac.getBlokiran());
                ocjenjivacRepository.save(ocjenjivac);
            }else{
                return "Korisnik se ne moze blokirati.";
            }
        }
        return "Korisnik uspjesno blokiran.";
    }
}
