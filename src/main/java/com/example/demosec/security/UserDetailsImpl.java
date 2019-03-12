package com.example.demosec.security;

import com.example.demosec.model.Papel;
import com.example.demosec.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private Usuario usuario;

    public UserDetailsImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        System.out.println("===== UserDetailsImpl.getAuthorities()");
        System.out.println("===== usuario " + this.usuario);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Papel papel : this.usuario.getPapeis()){
            System.out.println("===== usuario " + this.usuario.getUsername() + ", papel " + papel.getRole());
            authorities.add(new SimpleGrantedAuthority(papel.getRole()));
        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
