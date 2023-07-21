package com.trybac.learn.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Driver")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String mobile;
    private String email;
    private String password;
}