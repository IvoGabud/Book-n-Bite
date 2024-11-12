package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grupa {
    @Id
    @Column(nullable = false)
    private Long idGrupa;
    private Long kodGrupa;
    private String kategorijaGrupa;
    private String lokacijaGrupa;
    private Long listaJelaId;
}
