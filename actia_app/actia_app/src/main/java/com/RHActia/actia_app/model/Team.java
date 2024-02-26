package com.RHActia.actia_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int team_id;
    @Setter
    @Getter
    @Column(name = "team_name")
    private String team_name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Employee> members;
    private String Description;
    private String photo;

}