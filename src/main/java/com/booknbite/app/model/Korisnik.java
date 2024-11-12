package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String email;
    private String korisnicko_ime;
}
