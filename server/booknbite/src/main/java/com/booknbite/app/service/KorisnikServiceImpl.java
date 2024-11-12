package com.booknbite.app.service;

import com.booknbite.app.exception.ApiRequestException;
import com.booknbite.app.model.Korisnik;
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
    public Korisnik addKorisnik(OAuth2User token) {
        if(token == null) throw new ApiRequestException("All fields must be filled in order to create a new user.");

        Optional<Korisnik> login = korisnikRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        if (login.isPresent())
            return login.get();

        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnikId(token.getAttribute("sub"));
        korisnik.setKorisnickoIme(token.getAttribute("name"));
        korisnik.setEmail(token.getAttribute("email"));

        korisnikRepository.save(korisnik);
        return korisnik;
    }
}
