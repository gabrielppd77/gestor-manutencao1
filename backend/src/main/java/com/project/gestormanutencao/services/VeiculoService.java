package com.project.gestormanutencao.services;

import java.util.List;
import java.util.stream.Collectors;

import com.project.gestormanutencao.dto.VeiculoDTO;
import com.project.gestormanutencao.entities.Veiculo;
import com.project.gestormanutencao.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository repository; //REPOSITORY TEM TODOS OS VEICULOS DO BD

    public List<VeiculoDTO> findAll(){
        List<Veiculo> list = repository.findAll(); //PEGANDO OS VEICULOS E COLOCANDO NA LISTA

        return list.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList()); //EXPRESSAO LAMBDA PARA TRANSFORMA OS VEICULOS EM VEICULOSDTO
    }
}
