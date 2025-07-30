package com.fiap.substitutiva.application.usecase.avaliacao;

import com.fiap.substitutiva.domain.model.Avaliacao;

import java.util.List;

public interface BuscarAvaliacoesPorIdCliente {
    List<Avaliacao> buscarAvaliacoesPorIdCliente(Long idCliente);
}
