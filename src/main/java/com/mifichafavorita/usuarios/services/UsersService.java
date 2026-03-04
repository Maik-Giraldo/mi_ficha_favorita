package com.mifichafavorita.usuarios.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mifichafavorita.usuarios.dto.MessageResponseDTO;
import com.mifichafavorita.usuarios.dto.UsersRequestDTO;
import com.mifichafavorita.usuarios.dto.UsersResponseDTO;
import com.mifichafavorita.usuarios.entity.Users;
import com.mifichafavorita.usuarios.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

/**
 * Servicio encargado de la lógica de negocio para la gestión de usuarios.
 * Actúa como intermediario entre el controlador y la capa de datos
 * (Repository).
 */
@Service // Define esta clase como un Bean de Spring de tipo Servicio (Singleton)
@RequiredArgsConstructor // Genera el constructor para la inyección de dependencias de campos final
public class UsersService {

    // Repositorio inyectado para interactuar con la base de datos
    private final UsersRepository usersRepository;

    /**
     * Crea un nuevo usuario en el sistema.
     * * @param usersRequestDTO Objeto con los datos de entrada (nombre, email,
     * edad)
     * 
     * @return MessageResponseDTO confirmando la creación exitosa
     */
    public MessageResponseDTO createUser(UsersRequestDTO usersRequestDTO) {
        // 1. Mapeo de DTO (entrada) a Entidad (base de datos)
        Users user = new Users();
        user.setName(usersRequestDTO.getName());
        user.setEmail(usersRequestDTO.getEmail());
        user.setAge(usersRequestDTO.getAge());

        // 2. Persistencia: Guardamos el usuario en la BD
        usersRepository.save(user);

        // 3. Preparación de la respuesta
        MessageResponseDTO response = new MessageResponseDTO();
        response.setMessage("Usuario creado correctamente");

        return response;
    }

    /**
     * Obtiene la lista completa de usuarios registrados.
     * * @return Lista de UsersResponseDTO con la información pública de los
     * usuarios
     */
    public List<UsersResponseDTO> getUsers() {
        // Obtenemos todas las entidades de la base de datos
        List<Users> users = usersRepository.findAll();
        List<UsersResponseDTO> listUsers = new ArrayList<>();

        // Mapeamos cada entidad Users a un DTO de respuesta
        for (Users user : users) {
            UsersResponseDTO usersResponseDTO = new UsersResponseDTO();
            usersResponseDTO.setId(user.getId());
            usersResponseDTO.setName(user.getName());
            usersResponseDTO.setEmail(user.getEmail());
            usersResponseDTO.setAge(user.getAge());

            listUsers.add(usersResponseDTO);
        }
        return listUsers;
    }

    /**
     * Busca un usuario específico por su ID.
     * * @param id Identificador único del usuario
     * 
     * @return Un Optional que contiene el UsersResponseDTO si se encuentra,
     *         o un Optional vacío si no existe.
     */
    public Optional<UsersResponseDTO> getUser(Long id) {
        // Buscamos el usuario en el repositorio
        Optional<Users> optionalUser = usersRepository.findById(id);

        // Verificamos si el usuario existe antes de intentar mapearlo
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            UsersResponseDTO response = new UsersResponseDTO();

            // Mapeo de datos de la entidad encontrada al DTO
            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setAge(user.getAge());

            return Optional.of(response);
        } else {
            // Si no existe, devolvemos un Optional vacío para que el Controller maneje el
            // 404
            return Optional.empty();
        }
    }

    public MessageResponseDTO deleteUser(Long id) {
        MessageResponseDTO response = new MessageResponseDTO();
        if(usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            response.setMessage("Usuario eliminado correctamente");
            return response;
        }

        response.setMessage("Este usuario no existe");
        return response;

        // este cambio es de develop
        // este cambio es de mi rama
        // otro mas
    }
}