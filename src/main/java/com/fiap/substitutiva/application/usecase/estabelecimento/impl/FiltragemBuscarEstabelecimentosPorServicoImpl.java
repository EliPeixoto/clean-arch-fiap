package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.servico.BuscarServicoPorNome;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.List;

public class FiltragemBuscarEstabelecimentosPorServicoImpl {

    private final BuscarServicoPorNome buscarServicoPorNome;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public FiltragemBuscarEstabelecimentosPorServicoImpl(BuscarServicoPorNome buscarServicoPorNome, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.buscarServicoPorNome = buscarServicoPorNome;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }

    public List<Estabelecimento> buscarEstabelecimentosPorServico(String nomeServico) {
        return buscarServicoPorNome.buscarServicoPorNome(nomeServico)
                .stream()
                .map(servico -> buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(servico.getIdEstabelecimento()))
                .toList();
    }
}
