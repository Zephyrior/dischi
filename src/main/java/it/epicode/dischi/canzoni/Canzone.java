package it.epicode.dischi.canzoni;

import it.epicode.dischi.cantanti.Cantante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "canzoni")

public class Canzone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String titolo;

    @ManyToOne
    private Cantante cantante;

    @Column
    private String genere;


}