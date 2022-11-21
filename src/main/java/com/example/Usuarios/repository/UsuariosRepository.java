package com.example.Usuarios.repository;

import com.example.Usuarios.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    @Override
    void deleteById(Integer id);
}
