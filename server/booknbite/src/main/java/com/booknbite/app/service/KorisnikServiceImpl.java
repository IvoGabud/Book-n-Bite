package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Ocjenjivac addKorisnik(OAuth2User token) {

        Optional<Ocjenjivac> login = korisnikRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        if (login.isPresent())
            return login.get();

        Ocjenjivac korisnik = new Ocjenjivac();
        korisnik.setKorisnikId(token.getAttribute("sub"));
        korisnik.setKorisnickoIme(token.getAttribute("name"));
        korisnik.setEmail(token.getAttribute("email"));

        korisnikRepository.save(korisnik);
        return korisnik;
    }
}
