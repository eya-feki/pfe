package com.authjwt.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name ="app-user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column (name = "first_name",nullable = false)
    private String firstname;
    @Column (name = "last_name",nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
}
