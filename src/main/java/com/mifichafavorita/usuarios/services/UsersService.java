package com.mifichafavorita.usuarios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mifichafavorita.usuarios.dto.UsersRequestDTO;
import com.mifichafavorita.usuarios.dto.UsersResponseDTO;
import com.mifichafavorita.usuarios.entity.Users;
import com.mifichafavorita.usuarios.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service // bean (singleton)
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    
    // Método para crear un usuario
    public UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO) {
        // Creamos el objeto Users a partir del DTO que recibimos
        Users user = new Users();
        user.setName(usersRequestDTO.getName());
        user.setEmail(usersRequestDTO.getEmail());
        user.setAge(usersRequestDTO.getAge());

        // Guardamos el usuario en la base de datos
        usersRepository.save(user);

        // Creamos el DTO de respuesta a partir del usuario guardado
        UsersResponseDTO response = new UsersResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAge(user.getAge());

        // Devolvemos el DTO de respuesta
        return response;
    }

    public List<UsersResponseDTO> getUsers() {
        List<Users> users = usersRepository.findAll();
        List<UsersResponseDTO> listUsers = new ArrayList<>();
        
        for (Users user: users) {
            UsersResponseDTO usersResponseDTO = new UsersResponseDTO();
            usersResponseDTO.setId(user.getId());
            usersResponseDTO.setName(user.getName());
            usersResponseDTO.setEmail(user.getEmail());
            usersResponseDTO.setAge(user.getAge());
            listUsers.add(usersResponseDTO);
        }
        return listUsers;
    }
}
