package com.naja.client2.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

        private long id;

        private String nom;
        private String prenom;
        private int age;

}
