package com.booknbite.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocjena {
    @Id
    @Column(nullable = false)
    private Long brOcjena;
}
