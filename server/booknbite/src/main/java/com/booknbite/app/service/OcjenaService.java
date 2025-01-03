package com.booknbite.app.service;

import com.booknbite.app.model.request.CreateRatingRequest;

import java.util.List;

public interface OcjenaService {
    String spremiOcjene(String groupCode, Long userId, List<CreateRatingRequest> ratingRequest);
}
