package com.booknbite.app.service;

import com.booknbite.app.model.request.CreateRatingRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;

public interface OcjenaService {
    String spremiOcjene(String groupCode, OAuth2User token, CreateRatingRequest ratingRequest);
}
