package com.github.brunobach.unimed.rest.model.repository;

import com.github.brunobach.unimed.rest.model.entity.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}
