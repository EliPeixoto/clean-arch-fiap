package com.fiap.substitutiva.infra.controller.cliente;

import com.fiap.substitutiva.domain.model.Cliente;

public record ClienteDTO(
        Long id,
        String nome,
        String email
) {
    public ClienteDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
