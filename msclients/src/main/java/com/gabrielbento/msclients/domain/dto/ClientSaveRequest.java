package com.gabrielbento.msclients.domain.dto;

import com.gabrielbento.msclients.domain.entity.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}
