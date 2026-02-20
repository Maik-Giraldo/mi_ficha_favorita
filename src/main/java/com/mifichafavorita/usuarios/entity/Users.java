package com.mifichafavorita.usuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// Entidad que representa la tabla "users" en la base de datos
@Entity
@Data
@Table(name = "users")
public class Users {
    // Campo "id" es la clave primaria, se genera automáticamente con auto-incremento
    @Id
    // Estrategia de generación de ID, en este caso se delega a la base de datos (auto-incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Mapeo de la columna "id" en la tabla
    @Column(name = "id")
    private Long id;

    // Mapeo de la columna "name" en la tabla
    @Column(name = "name")
    private String name;

    // Mapeo de la columna "email" en la tabla
    @Column(name = "email")
    private String email;

    // Mapeo de la columna "age" en la tabla
    @Column(name = "age")
    private Long age;
}
