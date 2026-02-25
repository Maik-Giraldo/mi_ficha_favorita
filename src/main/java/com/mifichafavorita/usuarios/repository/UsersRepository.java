package com.mifichafavorita.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mifichafavorita.usuarios.entity.Users;

// Repositorio para la entidad Users, extiende JpaRepository para obtener métodos CRUD automáticamente
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
}