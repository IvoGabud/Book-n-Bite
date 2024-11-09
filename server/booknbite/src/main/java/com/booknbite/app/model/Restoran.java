package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long korisnikId;
    private String nazivrestoran;
    private String lokacija;
    private String radnovrijeme;
    private Cjenovnirang cjenovnirang;
    private String brojtelefona;
    private String poveznicaslike;

}
