package com.fiap.substitutiva.application.usecase.cliente;

import com.fiap.substitutiva.domain.model.Cliente;

public interface BuscarClientePorId {
    Cliente buscarClientePorId(Long id);
}
