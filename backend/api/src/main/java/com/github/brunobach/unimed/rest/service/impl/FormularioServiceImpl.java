package com.github.brunobach.unimed.rest.service.impl;

import com.github.brunobach.unimed.rest.model.entity.Formulario;
import com.github.brunobach.unimed.rest.model.repository.FormularioRepository;
import com.github.brunobach.unimed.rest.service.FormularioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class FormularioServiceImpl implements FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    @Override
    @Transactional
    public Formulario salvarFormulario(Formulario formulario) {
        return formularioRepository.save(formulario);
    }
}
