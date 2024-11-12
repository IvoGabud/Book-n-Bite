package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaJela {
    @Id
    @Column(nullable = false)
    private Long listaJelaId;
}
