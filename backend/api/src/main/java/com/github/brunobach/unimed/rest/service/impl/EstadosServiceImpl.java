package com.github.brunobach.unimed.rest.service.impl;

import com.github.brunobach.unimed.rest.Exception.BuscaInexistente;
import com.github.brunobach.unimed.rest.model.entity.Estados;
import com.github.brunobach.unimed.rest.model.repository.EstadosRepository;
import com.github.brunobach.unimed.rest.service.EstadosService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class EstadosServiceImpl implements EstadosService {

    @Autowired
    private EstadosRepository estadosRepository;

    @Override
    public Estados buscarEstado(Long id) throws BuscaInexistente {
        Optional<Estados> estadoOpt = estadosRepository.findById(id);
        if (!estadoOpt.isPresent()){
            throw new BuscaInexistente("Nenhum Estado encontrado com o id encaminhado.");
        }
        return estadoOpt.get();
    }

    @Override
    public List<Estados> listarTodos() {
        return estadosRepository.findAll();
    }
}
