package com.github.brunobach.unimed.rest.service.impl;

import com.github.brunobach.unimed.rest.Exception.BuscaInexistente;
import com.github.brunobach.unimed.rest.model.entity.Cidades;
import com.github.brunobach.unimed.rest.model.repository.CidadesRepository;
import com.github.brunobach.unimed.rest.service.CidadesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class CidadesServiceImpl implements CidadesService {

    @Autowired
    private CidadesRepository cidadesRepository;

    @Override
    public List<Cidades> buscarCidades(Long id) throws BuscaInexistente {
        Optional<List<Cidades>> listOptional = Optional.ofNullable(cidadesRepository.findAllByEstadoId(id));
        if (!listOptional.isPresent()){
            throw new BuscaInexistente("Nenhuma cidade encontrada com o id encaminhado.");
        }
        return listOptional.get().stream().collect(Collectors.toList());
    }
}
