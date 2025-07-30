package com.fiap.substitutiva.application.usecase.servico;

import com.fiap.substitutiva.domain.model.Servico;

import java.util.List;

public interface BuscarServicoPorNome {
    List<Servico> buscarServicoPorNome(String nome);
}
