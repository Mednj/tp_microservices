package com.naja.client2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Voiture {

    @Id
    @GeneratedValue
    private long id;
    private String matricule;
    private String marque;
    private String modele;
    private Long id_client;

    @Transient
    @ManyToOne
    private Client client;

    public Voiture(String matricule, String marque, String modele, Long id_client) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.id_client = id_client;
    }
}
