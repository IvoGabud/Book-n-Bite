package com.booknbite.app.service;

import com.booknbite.app.model.JeloRestoran;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;

public interface JeloRestoranService {
    List<JeloRestoran> getJeloRestoranList(String groupCode);
}
