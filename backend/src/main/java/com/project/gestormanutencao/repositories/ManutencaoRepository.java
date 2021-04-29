package com.project.gestormanutencao.repositories;

import com.project.gestormanutencao.entities.Manutencao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
