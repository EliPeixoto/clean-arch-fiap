package com.fiap.substitutiva.application.usecase.profissional.impl;

import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.domain.model.Profissional;

public class BuscarProfissionalPorIdImpl {

    private final BuscarProfissionalPorId buscarProfissionalPorId;

    public BuscarProfissionalPorIdImpl(BuscarProfissionalPorId buscarProfissionalPorId) {
        this.buscarProfissionalPorId = buscarProfissionalPorId;
    }

    public Profissional buscarPorIdProfissional(Long id) {
        return buscarProfissionalPorId.buscarPorId(id);
    }
}
