package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String nazivrRestoran;
    private String lokacija;
    private String radnoVrijeme;
    private CjenovniRang cjenovniRang;
    private String brojTelefona;
    private String poveznicaSlike;
}
