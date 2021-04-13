package com.project.gestormanutencao.controllers;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.project.gestormanutencao.dto.ManutencaoDTO;
import com.project.gestormanutencao.services.ManutencaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manutencoes")
public class ManutencaoController {
    
    @Autowired
    private ManutencaoService service;

    @GetMapping
    public ResponseEntity<List<ManutencaoDTO>> findAllExceptConcluidas() {
        List<ManutencaoDTO> manutencoes = service.findAllExceptConcluidas();
        return ResponseEntity.ok().body(manutencoes);
    }

    @GetMapping(value = "/concluidas")
    public ResponseEntity<List<ManutencaoDTO>> findAllConcluidas() {
        List<ManutencaoDTO> manutencoes = service.findAllConcluidas();
        return ResponseEntity.ok().body(manutencoes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ManutencaoDTO> findById(@PathVariable Long id){
        ManutencaoDTO manutencao = service.findById(id);
        return ResponseEntity.ok().body(manutencao);
    }

    @PostMapping
    public ResponseEntity<ManutencaoDTO> insert(@RequestBody ManutencaoDTO dto){
        ManutencaoDTO manutencao = service.insert(dto);
        return ResponseEntity.ok().body(manutencao);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ManutencaoDTO> update(@RequestBody ManutencaoDTO dto, @PathVariable Long id){
        ManutencaoDTO manutencao = service.update(dto, id);
        return ResponseEntity.ok().body(manutencao);
    }
}
