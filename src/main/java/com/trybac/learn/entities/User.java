package com.trybac.learn.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "AppUser")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String mobile;
    private String email;
    private String password;
}
