package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.domain.model.Estabelecimento;

public class BuscarEstabelecimentoPorIdImpl {

    private final BuscarEstabelecimentoPorId estabelecimentoPorId;

    public BuscarEstabelecimentoPorIdImpl(BuscarEstabelecimentoPorId estabelecimentoPorId) {
        this.estabelecimentoPorId = estabelecimentoPorId;
    }

    public Estabelecimento buscarEstabelecimentoPorId(Long id) {
        return estabelecimentoPorId.buscarEstabelecimentoPorId(id);
    }
}
