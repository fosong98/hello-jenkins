package com.example.hellojenkins.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity (name = "users")
@NoArgsConstructor
public class User {
    @GeneratedValue @Id
    private Long id;
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
