package it.epicode.dischi.cantanti;

import it.epicode.dischi.canzoni.Canzone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cantanti")

public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;

    @OneToMany(mappedBy = "cantante")
    private List<Canzone> canzoni;

}