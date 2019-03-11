package com.example.demosec.security;

import com.example.demosec.model.Papel;
import com.example.demosec.model.Usuario;
import com.example.demosec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        Long cpf = null;
//        try {
//            cpf = Long.parseLong(username);
//        } catch (Exception ex) {
//            throw new UsernameNotFoundException("CPF não é um valor numérico");
//        }

        Usuario usuario = usuarioService.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new UserDetailsImpl(usuario);
    }
}
