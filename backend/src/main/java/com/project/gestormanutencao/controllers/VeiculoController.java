package com.project.gestormanutencao.controllers;

import java.net.URI;
import java.util.List;

import com.project.gestormanutencao.dto.VeiculoDTO;
import com.project.gestormanutencao.entities.Veiculo;
import com.project.gestormanutencao.services.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        Veiculo veiculo = service.findById(id);

        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }
    
    @PostMapping
    public ResponseEntity<VeiculoDTO> insert(@RequestBody VeiculoDTO dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoDTO dto) {
        VeiculoDTO newVeiculo = service.update(id, dto);
        return ResponseEntity.ok().body(newVeiculo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
