package it.epicode.dischi.cantanti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CantanteRequest {

    private String nome;
    private String cognome;
}
