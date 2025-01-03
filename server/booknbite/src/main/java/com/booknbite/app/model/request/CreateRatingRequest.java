package com.booknbite.app.model.request;

public class CreateRatingRequest {
    private Long jeloId;
    private Integer rating;

    public CreateRatingRequest(){

    }

    public Long getJeloId() {
        return jeloId;
    }

    public void setJeloId(Long jeloId) {
        this.jeloId = jeloId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
