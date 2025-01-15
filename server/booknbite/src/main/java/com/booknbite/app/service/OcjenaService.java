package com.booknbite.app.service;

import com.booknbite.app.model.request.RestoranShortDTO;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;

public interface OcjenaService {
    String spremiOcjene(String groupCode, OAuth2User token, Map<String, Integer> ratingRequest);
    Boolean provjeriOcjene(String groupCode);
    List<RestoranShortDTO> kalkulirajPreporuku(String groupCode);
}
