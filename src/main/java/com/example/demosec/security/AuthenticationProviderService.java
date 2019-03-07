package com.example.demosec.security;

import com.example.demosec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationProviderService implements AuthenticationProvider {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        String login = auth.getName();
        String senha = auth.getCredentials().toString();

        // Defina suas regras para realizar a autenticação
/*
        if (usuarioBd != null) {
            if (usuarioAtivo(usuarioBd)) {
                Collection<? extends GrantedAuthority> authorities = usuarioBd.getPapeis();
                return new UsernamePasswordAuthenticationToken(login, senha, authorities);
            } else {
                throw new BadCredentialsException("Este usuário está desativado.");
            }
        }
*/

        throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
//        return auth.equals(UsernamePasswordAuthenticationToken.class);
        return false;
    }
}
