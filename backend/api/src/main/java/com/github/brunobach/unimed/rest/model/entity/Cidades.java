package com.github.brunobach.unimed.rest.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cidades {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "codigo_ibge")
    private Long codigoIbge;
    @Column(name = "estado_id")
    private Long estadoId;
    @Column(name = "populacao_2010")
    private Long populacao_2010;
    @Column(name = "densidade_demo")
    private Float densidadeDemo;
    @Column(name = "gentilico")
    private String gentilico;
    @Column(name = "area")
    private Float area;

}
