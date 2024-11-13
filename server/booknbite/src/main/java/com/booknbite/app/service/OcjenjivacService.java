package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OcjenjivacService {
    Ocjenjivac addOcjenjivac(OAuth2User token);
    Ocjenjivac retrieveOcjenjivac(OAuth2User token);
}
