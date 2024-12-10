package com.project.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String sexe;
    private String telephone;
    private int age;
    private String cin;
    private String password;
    private String email;
    private String role = "user";

    public User(){
        
    }
    public User(String id, String username, String password,String telephone, String cin, int age, String sexe, String email ) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.cin = cin;
        this.age = age;
        this.sexe = sexe;
        this.email=email;
    }

    // other user details, roles, etc.
}
