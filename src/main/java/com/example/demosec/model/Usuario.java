package com.example.demosec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false, unique = true)
    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private Long cpf;

    @JsonIgnore
    @Column(length = 200, nullable = false)
    private String senha;

    @Column(nullable = false)
    private Boolean ativo = true;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "usuario_papel",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_papel")})
    private Set<Papel> papeis = new HashSet<>();

    public void setSenha(String senha) {
        this.senha = bCryptPasswordEncoder.encode(senha);
    }
}
