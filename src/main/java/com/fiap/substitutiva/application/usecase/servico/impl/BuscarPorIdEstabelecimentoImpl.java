package com.fiap.substitutiva.application.usecase.servico.impl;

import com.fiap.substitutiva.application.usecase.servico.BuscarPorIdEstabelecimento;
import com.fiap.substitutiva.domain.model.Servico;

import java.util.List;

public class BuscarPorIdEstabelecimentoImpl {

    private final BuscarPorIdEstabelecimento buscarPorIdEstabelecimento;

    public BuscarPorIdEstabelecimentoImpl(BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        this.buscarPorIdEstabelecimento = buscarPorIdEstabelecimento;
    }

    public List<Servico> buscarPorIdEstabelecimento(Long id) {
        return buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(id);
    }
}
