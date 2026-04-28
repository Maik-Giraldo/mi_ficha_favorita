package com.mifichafavorita.gestionusuarios.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    /**
     * Nombre del usuario
     */
    private String name;

    /**
     * Email del usuario
     */
    private String email;

    /**
     * Edad del usuario
     */
    private Long age;
}
