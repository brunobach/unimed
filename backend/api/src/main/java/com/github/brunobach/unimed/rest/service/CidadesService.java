package com.github.brunobach.unimed.rest.service;

import com.github.brunobach.unimed.rest.Exception.BuscaInexistente;
import com.github.brunobach.unimed.rest.model.entity.Cidades;

import java.util.List;

public interface CidadesService {

    List<Cidades> buscarCidades(Long id) throws BuscaInexistente;
}
