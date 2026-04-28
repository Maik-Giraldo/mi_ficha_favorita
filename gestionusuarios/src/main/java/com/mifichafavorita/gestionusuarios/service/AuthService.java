package com.mifichafavorita.gestionusuarios.service;

import com.mifichafavorita.gestionusuarios.repository.UserRepository;

import org.springframework.stereotype.Service;

import com.mifichafavorita.gestionusuarios.dto.RegisterRequestDTO;
import com.mifichafavorita.gestionusuarios.dto.RegisterResponseDTO;
import com.mifichafavorita.gestionusuarios.entity.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    /**
     * Repositorio de usuarios
     */
    private final UserRepository userRepository;

    public RegisterResponseDTO register(RegisterRequestDTO request) {
        RegisterResponseDTO response = new RegisterResponseDTO();

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
             response.setMessage("El correo ya está en uso");
             return response;
        }

        Users user = new Users();
        user.setName(request.getName());
    }
}
