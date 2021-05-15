package com.github.brunobach.unimed.rest.model.repository;

import com.github.brunobach.unimed.rest.model.entity.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadesRepository extends JpaRepository<Cidades, Long> {
    List<Cidades> findAllByEstadoId(Long id);
}
