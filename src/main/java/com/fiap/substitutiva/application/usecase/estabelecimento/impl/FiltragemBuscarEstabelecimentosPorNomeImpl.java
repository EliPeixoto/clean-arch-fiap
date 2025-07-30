package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.FiltragemBuscarEstabelecimentosPorNome;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.List;

public class FiltragemBuscarEstabelecimentosPorNomeImpl {

    private final FiltragemBuscarEstabelecimentosPorNome filtragemBuscarEstabelecimentosPorNome;

    public FiltragemBuscarEstabelecimentosPorNomeImpl(FiltragemBuscarEstabelecimentosPorNome filtragemBuscarEstabelecimentosPorNome) {
        this.filtragemBuscarEstabelecimentosPorNome = filtragemBuscarEstabelecimentosPorNome;
    }

    public List<Estabelecimento> buscarPorNome(String nome) {
        return filtragemBuscarEstabelecimentosPorNome.buscarPorNome(nome);
    }
}
