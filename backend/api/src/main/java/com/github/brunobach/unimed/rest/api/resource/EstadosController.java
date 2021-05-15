package com.github.brunobach.unimed.rest.api.resource;


import com.github.brunobach.unimed.rest.Exception.BuscaInexistente;
import com.github.brunobach.unimed.rest.model.entity.Estados;
import com.github.brunobach.unimed.rest.service.EstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/estados")
public class EstadosController {


    @Autowired
    private EstadosService estadosService;

    @GetMapping("/{id}")
    public Estados buscarEstado(@PathVariable String id) throws BuscaInexistente {

        return estadosService.buscarEstado(Long.valueOf(id));
    }

    @GetMapping
    public List<Estados> listarTodos() {
        return estadosService.listarTodos();
    }
}
