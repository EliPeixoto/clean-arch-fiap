package com.fiap.substitutiva.application.usecase.avaliacao.impl;

import com.fiap.substitutiva.application.usecase.avaliacao.BuscarAvaliacaoPorId;
import com.fiap.substitutiva.application.usecase.avaliacao.EditarAvaliacao;
import com.fiap.substitutiva.domain.model.Avaliacao;

import java.util.NoSuchElementException;
import java.util.Objects;

public class EditarAvaliacaoImpl {

    private final EditarAvaliacao editarAvaliacao;
    private final BuscarAvaliacaoPorId buscarAvaliacaoPorId;

    public EditarAvaliacaoImpl(EditarAvaliacao editarAvaliacao, BuscarAvaliacaoPorId buscarAvaliacaoPorId) {
        this.editarAvaliacao = editarAvaliacao;
        this.buscarAvaliacaoPorId = buscarAvaliacaoPorId;
    }

    public Avaliacao editar(Avaliacao avaliacao) {
        if(Objects.isNull(buscarAvaliacaoPorId.buscarAvaliacaoPorId(avaliacao.getId()))) {
            throw new NoSuchElementException("Não foi possível encontrar a avaliação");
        }
        return editarAvaliacao.editarAvaliacao(avaliacao);
    }
}
