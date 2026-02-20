package com.mifichafavorita.usuarios.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mifichafavorita.usuarios.dto.UsersRequestDTO;
import com.mifichafavorita.usuarios.dto.UsersResponseDTO;
import com.mifichafavorita.usuarios.services.UsersService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users") // context path solamente para este controller
public class UsersController {
    private final UsersService usersService;

    @PostMapping // Petición Post
    // @RequestBody (viene del cuerpo de la solicitud)
    // ResponseEntity (Codigo http personalizable)
    public ResponseEntity<UsersResponseDTO> createUser(@RequestBody UsersRequestDTO usersRequestDTO) {
        try {
            // Llamamos al servicio para crear el usuario y obtener el DTO de respuesta
            UsersResponseDTO response = usersService.createUser(usersRequestDTO);

            // Devolvemos el DTO de respuesta con el código HTTP 201 (CREATED)
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            // En caso de error, imprimimos la traza y devolvemos un código HTTP 400 (BAD
            // REQUEST)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> getUsers() {
        try {
            List<UsersResponseDTO> response = usersService.getUsers();
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
