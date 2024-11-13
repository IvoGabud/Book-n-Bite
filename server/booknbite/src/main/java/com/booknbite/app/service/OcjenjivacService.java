package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.request.CreateGrupaRequest;
import com.booknbite.app.model.request.CreateOcjenjivacRequest;
import com.booknbite.app.model.request.OcjenjivacBool;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OcjenjivacService {
    Ocjenjivac addOcjenjivac(OAuth2User token, CreateOcjenjivacRequest ocjenjivacRequest);
    OcjenjivacBool retrieveOcjenjivac(OAuth2User token);
    Grupa createGrupa(CreateGrupaRequest grupaRequest);
}
