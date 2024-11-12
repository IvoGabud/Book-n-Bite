package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final OcjenjivacRepository ocjenjivacRepository;

    @Autowired
    public KorisnikServiceImpl(OcjenjivacRepository ocjenjivacRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
    }

    @Override
    public Ocjenjivac addKorisnik(OAuth2User token) {

        Optional<Ocjenjivac> login = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        if (login.isPresent())
            return login.get();

        Ocjenjivac korisnik = new Ocjenjivac();
        korisnik.setOcjenjivacId(token.getAttribute("sub"));
        korisnik.setOcjenjivacIme(token.getAttribute("name"));
        korisnik.setEmail(token.getAttribute("email"));

        ocjenjivacRepository.save(korisnik);
        return korisnik;
    }
}
