package com.example.demosec.controller;

import com.example.demosec.model.Papel;
import com.example.demosec.model.Usuario;
import com.example.demosec.service.PapelService;
import com.example.demosec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PapelService papelService;

    @GetMapping()
    public List<Usuario> findAllUsuarios() { return usuarioService.findAll(); }

    @GetMapping("/papeis")
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    public List<Papel> findAllPapeis() { return papelService.findAll(); }

    @GetMapping("/total")
    @PreAuthorize("hasRole('ROLE_GESTOR')")
    public Integer getTotalPapeis() { return papelService.findAll().size(); }

    @GetMapping("/auditor")
    @PreAuthorize("hasRole('ROLE_AUDITOR')")
    public Integer getTotalUsuarios() { return usuarioService.findAll().size(); }
}
