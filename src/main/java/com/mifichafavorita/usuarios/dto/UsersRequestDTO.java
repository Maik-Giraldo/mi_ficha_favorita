package com.mifichafavorita.usuarios.dto;

import lombok.Data;

@Data
public class UsersRequestDTO {
    private String name;

    private String email;

    private Long age;
}
