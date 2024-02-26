package com.RHActia.actia_app.model;

import jakarta.persistence.*;
import lombok.*;




@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String photo;


 }