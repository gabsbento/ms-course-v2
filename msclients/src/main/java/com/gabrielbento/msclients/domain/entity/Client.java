package com.gabrielbento.msclients.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String name;
    @Column
    private Integer age;

    public Client(String cpf, String name, Integer age){
        this.age = age;
        this.cpf = cpf;
        this.name = name;
    }
}
