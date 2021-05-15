package com.github.brunobach.unimed.rest.service;

import com.github.brunobach.unimed.rest.Exception.BuscaInexistente;
import com.github.brunobach.unimed.rest.model.entity.Estados;

import java.util.List;


public interface EstadosService {

    Estados buscarEstado(Long id) throws BuscaInexistente;
    List<Estados> listarTodos();
}
