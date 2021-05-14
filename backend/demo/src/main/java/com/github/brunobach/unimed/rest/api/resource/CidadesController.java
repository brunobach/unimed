package com.github.brunobach.unimed.rest.api.resource;


import com.github.brunobach.unimed.rest.Exception.BuscaInexistente;
import com.github.brunobach.unimed.rest.model.entity.Cidades;
import com.github.brunobach.unimed.rest.service.CidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cidades")
public class CidadesController {

    @Autowired
    private CidadesService cidadesService;

    @GetMapping("/{idEstado}")
    public List<Cidades> buscarCidades(@PathVariable String idEstado) throws BuscaInexistente {

        return cidadesService.buscarCidades(Long.valueOf(idEstado));
    }



}
