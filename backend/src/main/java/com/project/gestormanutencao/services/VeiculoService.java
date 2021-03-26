package com.project.gestormanutencao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.gestormanutencao.dto.VeiculoDTO;
import com.project.gestormanutencao.entities.Veiculo;
import com.project.gestormanutencao.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository repository; //REPOSITORY TEM TODOS OS VEICULOS DO BD

    public List<VeiculoDTO> findAll(){
        List<Veiculo> list = repository.findAll(); //PEGANDO OS VEICULOS E COLOCANDO NA LISTA

        return list.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList()); //EXPRESSAO LAMBDA PARA TRANSFORMA OS VEICULOS EM VEICULOSDTO
    }

    public Veiculo findById(Long id){
        Optional<Veiculo> veiculo = repository.findById(id);

        return veiculo.get();
    }

    public VeiculoDTO insert(VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo(null, dto.getPlaca(), dto.getKm(), dto.getModelo(), dto.getFabricacao(), dto.getAno(), dto.getChassi(), dto.getTipo());

        veiculo = repository.save(veiculo);

        return new VeiculoDTO(veiculo);
    }

    public VeiculoDTO update(Long id, VeiculoDTO dto) {
        Veiculo veiculo = findById(id);

        veiculo.setPlaca(dto.getPlaca());
        veiculo.setKm(dto.getKm());
        veiculo.setModelo(dto.getModelo());
        veiculo.setFabricacao(dto.getFabricacao());
        veiculo.setAno(dto.getAno());
        veiculo.setChassi(dto.getChassi());
        veiculo.setTipo(dto.getTipo());

        repository.save(veiculo);

        return new VeiculoDTO(veiculo);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Veiculo não pode ser deletado! Tem associações");
        }
        
    }
}
