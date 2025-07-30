package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.estabelecimento.EditarEstabelecimento;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.NoSuchElementException;
import java.util.Objects;

public class EditarEstabelecimentoPorIdImpl {

    private final EditarEstabelecimento editarEstabelecimento;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public EditarEstabelecimentoPorIdImpl(EditarEstabelecimento editarEstabelecimento, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.editarEstabelecimento = editarEstabelecimento;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }
    public Estabelecimento editarEstabelecimento(Estabelecimento estabelecimento) {
        if(Objects.isNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(estabelecimento.getId()))){
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }
        return editarEstabelecimento.editarEstabelecimento(estabelecimento);
    }
}
