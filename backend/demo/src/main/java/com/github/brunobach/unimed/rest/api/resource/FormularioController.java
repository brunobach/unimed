package com.github.brunobach.unimed.rest.api.resource;

import com.github.brunobach.unimed.rest.api.dto.FormularioPOSTDTO;
import com.github.brunobach.unimed.rest.model.entity.Formulario;
import com.github.brunobach.unimed.rest.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/formulario")
public class FormularioController {

    @Autowired
    private FormularioService formularioService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody FormularioPOSTDTO dto) {
        String data = LocalDate.now().toString().replaceAll("-", "");
        String protocolo = data + dto.getTelefone();
        Formulario formulario = Formulario.builder()
                .protocolo(protocolo)
                .nome(dto.getNome())
                .email(dto.getEmail())
                .estado(dto.getEstado())
                .cidade(dto.getCidade())
                .telefone(dto.getTelefone())
                .mensagem(dto.getMensagem())
                .build();

        try {
            Formulario formularioSalvo = formularioService.salvarFormulario(formulario);
            return new ResponseEntity(formularioSalvo.getProtocolo(), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
