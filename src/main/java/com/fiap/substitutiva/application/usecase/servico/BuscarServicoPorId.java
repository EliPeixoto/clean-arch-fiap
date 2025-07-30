package com.fiap.substitutiva.application.usecase.servico;

import com.fiap.substitutiva.domain.model.Servico;

public interface BuscarServicoPorId {

    Servico buscarServicoPorId(Long id);
}
