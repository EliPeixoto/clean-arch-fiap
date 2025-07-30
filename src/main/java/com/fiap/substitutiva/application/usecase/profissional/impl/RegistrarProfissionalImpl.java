package com.fiap.substitutiva.application.usecase.profissional.impl;

import com.fiap.substitutiva.application.usecase.profissional.RegistrarProfissional;
import com.fiap.substitutiva.domain.model.Profissional;

public class RegistrarProfissionalImpl {

    private final RegistrarProfissional registrarProfissional;

    public RegistrarProfissionalImpl(RegistrarProfissional registrarProfissional) {
        this.registrarProfissional = registrarProfissional;
    }

    public Profissional registrarProfissional(Profissional profissional) {
        profissional.setIdEstabelecimento(null);
        return registrarProfissional.registrar(profissional);
    }
}
