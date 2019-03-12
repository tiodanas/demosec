package com.example.demosec.service;

import com.example.demosec.model.Papel;
import com.example.demosec.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapelService {

    @Autowired
    PapelRepository papelRepository;

    public List<Papel> findAll() { return papelRepository.findAll(); }
}
