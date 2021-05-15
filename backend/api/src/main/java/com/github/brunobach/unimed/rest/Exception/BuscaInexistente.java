package com.github.brunobach.unimed.rest.Exception;

import javassist.NotFoundException;

public class BuscaInexistente extends NotFoundException {

    public BuscaInexistente(String message) {
        super(message);
    }
}