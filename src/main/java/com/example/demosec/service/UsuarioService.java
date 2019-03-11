package com.example.demosec.service;

import com.example.demosec.model.Usuario;
import com.example.demosec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
//        return usuarioRepository.findAll(new Sort(Sort.Direction.ASC, "nome"));
        return usuarioRepository.findAll();
    }

//    public Optional<Usuario> findByCpf(Long cpf) { return usuarioRepository.findByCpf(cpf);}

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
