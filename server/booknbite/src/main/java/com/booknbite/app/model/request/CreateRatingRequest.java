package com.booknbite.app.model.request;

import java.util.Map;

public class CreateRatingRequest {
    private Map<Long, Integer> map;

    public CreateRatingRequest(){

    }

    public Map<Long, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Long, Integer> map) {
        this.map = map;
    }
}
