package com.booknbite.app.service;

import com.booknbite.app.exception.ApiRequestException;
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
        if(token == null) throw new ApiRequestException("All fields must be filled in order to create a new user.");

        Optional<Ocjenjivac> login = korisnikRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        if (login.isPresent())
            return login.get();

        Ocjenjivac ocjenjivac = new Ocjenjivac();
        ocjenjivac.setKorisnikId(token.getAttribute("sub"));
        ocjenjivac.setKorisnickoIme(token.getAttribute("name"));
        ocjenjivac.setEmail(token.getAttribute("email"));

        korisnikRepository.save(ocjenjivac);
        return ocjenjivac;
    }
}
