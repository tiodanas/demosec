package com.example.demosec.repository;

import com.example.demosec.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    Optional<Usuario> findByCpf(Long cpf);
//    Usuario findByEmail(String email);
    Usuario findByUsername(String username);
}
