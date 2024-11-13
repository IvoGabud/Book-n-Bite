package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
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

    @Autowired
    public OcjenjivacServiceImpl(OcjenjivacRepository ocjenjivacRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
    }

    @Override
    public Ocjenjivac addOcjenjivac(OAuth2User token, CreateOcjenjivacRequest ocjenjivacRequest) {

        Optional<Ocjenjivac> login = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        if (login.isPresent())
            return login.get();

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

    @Override
    public OcjenjivacBool retrieveOcjenjivac(OAuth2User token) {

        Optional<Ocjenjivac> login = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        OcjenjivacBool ocjenjivac = new OcjenjivacBool();

        ocjenjivac.setOcjenjivacId(token.getAttribute("sub"));
        ocjenjivac.setOcjenjivacIme(token.getAttribute("name"));
        ocjenjivac.setEmail(token.getAttribute("email"));

        if(login.isPresent()){
            ocjenjivac.setRegistered(true);
            return ocjenjivac;
        }

        ocjenjivac.setRegistered(false);
        return ocjenjivac;
    }

}
