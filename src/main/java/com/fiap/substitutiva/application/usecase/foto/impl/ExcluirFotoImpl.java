package com.fiap.substitutiva.application.usecase.foto.impl;

import com.fiap.substitutiva.application.usecase.foto.ExcluirFoto;

public class ExcluirFotoImpl {

    private final ExcluirFoto excluirFoto;

    public ExcluirFotoImpl(ExcluirFoto excluirFoto) {
        this.excluirFoto = excluirFoto;
    }

    public void excluir(Long id) {
        excluirFoto.excluirFoto(id);
    }
}
