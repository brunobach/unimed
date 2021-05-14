package com.github.brunobach.unimed.rest.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "formulario" )
public class Formulario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="protocolo")
    private String protocolo;

    @Column(name = "nome")
    private String nome;

    @Column(name ="email")
    private String email;

    @Column(name ="estado")
    private String estado;

    @Column(name ="cidade")
    private String cidade;

    @Column(name ="telefone")
    private String telefone;

    @Column(name ="mensagem")
    private String mensagem;


}
