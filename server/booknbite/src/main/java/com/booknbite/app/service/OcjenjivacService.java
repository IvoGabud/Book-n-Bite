package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.OcjenjivacBool;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OcjenjivacService {
    Ocjenjivac addOcjenjivac(OAuth2User token);
    OcjenjivacBool retrieveOcjenjivac(OAuth2User token);
}
