package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.avaliacao.VerTodasAsAvaliacoes;
import com.fiap.substitutiva.domain.model.Avaliacao;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;


public class FiltragemBuscarEstabelecimentosPorEstrelasImpl {

    private final VerTodasAsAvaliacoes verTodasAsAvaliacoes;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public FiltragemBuscarEstabelecimentosPorEstrelasImpl(VerTodasAsAvaliacoes verTodasAsAvaliacoes, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.verTodasAsAvaliacoes = verTodasAsAvaliacoes;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }

    public List<Estabelecimento> listaEstabelecimentosPorEstrelas(int estrelas) {
        List<Avaliacao> avaliacoes = verTodasAsAvaliacoes.verTodasAsAvaliacoes();
        Map<Long, Double> medias = avaliacoes
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Avaliacao::getIdEstabelecimento,
                                Collectors.averagingDouble(Avaliacao::getEstrelas)
                        ));

        double max = (estrelas == 5) ? 5.0001 : estrelas + 1.0;

        return medias.entrySet().stream()
                .filter(entry -> entry.getValue() >= estrelas && entry.getValue() < max)
                .map(entry -> {
                    try {
                        return buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(entry.getKey());
                    } catch (NoSuchElementException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
