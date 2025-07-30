package com.fiap.substitutiva.infra.gateway.cliente;

import com.fiap.substitutiva.domain.model.Cliente;
import com.fiap.substitutiva.infra.persistence.cliente.ClienteEntity;

public class ClienteMapper {

    public Cliente toDomain(ClienteEntity in) {
        return new Cliente(
                in.getId(),
                in.getNome(),
                in.getEmail()
        );
    }

    public ClienteEntity toEntity(Cliente in) {
        return new ClienteEntity(
                in.getId(),
                in.getNome(),
                in.getEmail()
        );
    }
}
