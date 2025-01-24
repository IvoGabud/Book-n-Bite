package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.request.UpdateOcjenjivacRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OcjenjivacService {

    Ocjenjivac ocjenjivacPodaci(OAuth2User token);
    String urediPodatke(OAuth2User token, UpdateOcjenjivacRequest ocjenjivacRequest);
    String izadiIzGrupe(OAuth2User token);
}
