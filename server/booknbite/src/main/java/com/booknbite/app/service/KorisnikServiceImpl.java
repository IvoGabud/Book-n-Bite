package com.booknbite.app.service;

import com.booknbite.app.exception.ApiRequestException;
import com.booknbite.app.model.Korisnik;
import com.booknbite.app.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public String addKorisnik(Korisnik korisnik) {
        if(korisnik == null ||
                korisnik.getKorisnikId() == null ||
                korisnik.getKorisnickoIme() == null ||
                korisnik.getLozinka() == null)
            throw new ApiRequestException("All fields must be filled in order to create a new user.");
        korisnikRepository.save(korisnik);
        return "Korisnik je dodan u bazu.";
    }
}
