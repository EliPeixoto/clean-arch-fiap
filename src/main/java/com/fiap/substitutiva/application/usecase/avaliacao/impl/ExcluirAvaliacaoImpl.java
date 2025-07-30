package com.fiap.substitutiva.application.usecase.avaliacao.impl;

import com.fiap.substitutiva.application.usecase.avaliacao.ExcluirAvaliacao;

public class ExcluirAvaliacaoImpl {

    private final ExcluirAvaliacao excluirAvaliacao;

    public ExcluirAvaliacaoImpl(ExcluirAvaliacao excluirAvaliacao) {
        this.excluirAvaliacao = excluirAvaliacao;
    }

    public void excluirAvaliacao(Long id) {
        excluirAvaliacao.excluir(id);
    }
}
