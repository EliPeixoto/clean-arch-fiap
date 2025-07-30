package com.fiap.substitutiva.application.usecase.estabelecimento;

import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.List;

public interface FiltragemBuscarEstabelecimentosPorNome {
    List<Estabelecimento> buscarPorNome(String nome);
}
