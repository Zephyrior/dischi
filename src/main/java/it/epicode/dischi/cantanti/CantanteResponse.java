package it.epicode.dischi.cantanti;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CantanteResponse {

    private Long id;
    private String nome;
    private String cognome;
}
