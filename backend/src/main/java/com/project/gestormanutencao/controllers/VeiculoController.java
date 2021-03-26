package com.project.gestormanutencao.controllers;

import java.util.List;

import com.project.gestormanutencao.dto.VeiculoDTO;
import com.project.gestormanutencao.services.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoService service;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {

        List<VeiculoDTO> list = service.findAll(); //PEGOU OS VEICULOS QUE JA ESTAVAM PRONTOS NO SERVICE

        return ResponseEntity.ok().body(list);
    }
    
}
