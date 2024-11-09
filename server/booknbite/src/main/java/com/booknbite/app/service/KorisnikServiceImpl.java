package com.booknbite.app.service;

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
    public boolean addKorisnik(Korisnik korisnik) {
        korisnikRepository.save(korisnik);
        return true;
    }
}
