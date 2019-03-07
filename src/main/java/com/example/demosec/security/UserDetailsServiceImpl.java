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


    /**
     * @param username deve ser o cpf, sem máscara - somente os números
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Long cpf = null;
        try {
            cpf = Long.parseLong(username);
        } catch (Exception ex) {
            throw new UsernameNotFoundException("CPF não é um valor numérico");
        }

        Optional<Usuario> usuarioOptional = usuarioService.findByCpf(cpf);

        if (!usuarioOptional.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOptional.get();

        return new User(usuario.getCpf().toString(), usuario.getSenha(), getGrantedAuthorities(usuario));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Usuario usuario){

        List<GrantedAuthority> authorities = new ArrayList<>();

        for(Papel papel : usuario.getPapeis()){
//            System.out.println("UserProfile : " + papel);
            authorities.add(new SimpleGrantedAuthority(papel.getRole()));
        }
//        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
