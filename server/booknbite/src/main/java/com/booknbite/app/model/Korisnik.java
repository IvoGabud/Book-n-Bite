package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Korisnik {
    @Id
    @Column(nullable = false)
    private Long korisnikId;
    private String korisnickoIme;
    private String email;
}
