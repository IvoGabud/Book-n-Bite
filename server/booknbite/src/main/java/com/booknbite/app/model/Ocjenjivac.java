package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocjenjivac {
    @Id
    @Column(nullable = false)
    private Long korisnikId;
    private String korisnickoIme;
    private String email;
}
