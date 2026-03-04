package com.mifichafavorita.usuarios.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mifichafavorita.usuarios.dto.MessageResponseDTO;
import com.mifichafavorita.usuarios.dto.UsersRequestDTO;
import com.mifichafavorita.usuarios.dto.UsersResponseDTO;
import com.mifichafavorita.usuarios.services.UsersService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controlador REST para gestionar las operaciones de usuarios.
 * Define los endpoints accesibles a través de HTTP.
 */
@RestController // Define esta clase como un controlador donde cada método devuelve un objeto
                // JSON
@RequiredArgsConstructor // Inyecta automáticamente el UsersService mediante el constructor
@RequestMapping("/users") // Ruta base para todos los endpoints de este controlador (ej:
                          // localhost:9090/users)
public class UsersController {

    private final UsersService usersService;

    /**
     * Endpoint para crear un nuevo usuario.
     * 
     * @param usersRequestDTO Datos del usuario enviados en el cuerpo (JSON) de la
     *                        petición.
     * @return ResponseEntity con mensaje de éxito (201 Created) o error (400 Bad
     *         Request).
     */
    @PostMapping()
    public ResponseEntity<MessageResponseDTO> createUser(@RequestBody UsersRequestDTO usersRequestDTO) {
        try {
            // Llama al servicio para persistir el usuario
            MessageResponseDTO response = usersService.createUser(usersRequestDTO);
            // HttpStatus.CREATED (201) es el estándar para creaciones exitosas
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Endpoint para obtener la lista de todos los usuarios.
     * 
     * @return Lista de usuarios con código 302 (Found) o 400 en caso de error.
     */
    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> getUsers() {
        try {
            List<UsersResponseDTO> response = usersService.getUsers();
            // Nota: HttpStatus.FOUND (302) se usa comúnmente para redirecciones.
            // Para una lista exitosa, lo más común es HttpStatus.OK (200).
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Endpoint para obtener un usuario específico por su ID.
     * 
     * @param id Identificador único tomado de la URL (/users/{id}).
     * @return El usuario encontrado (302 Found) o error 404 si ocurre una
     *         excepción.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsersResponseDTO>> getUser(@PathVariable Long id) {
        try {
            Optional<UsersResponseDTO> response = usersService.getUser(id);

            // Si el servicio devuelve un Optional vacío, aquí podrías manejar un 404 manual
            // Por ahora, devuelve lo que encuentre con código 302.
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            // Captura errores inesperados y responde con 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> deleteUser(@PathVariable Long id) {
        try {
            MessageResponseDTO response = usersService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}