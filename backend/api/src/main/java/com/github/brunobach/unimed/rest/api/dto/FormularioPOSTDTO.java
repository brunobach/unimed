package com.github.brunobach.unimed.rest.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormularioPOSTDTO {

    private String nome;

    private String email;

    private String estado;

    private String cidade;

    private String telefone;

    private String mensagem;

}
