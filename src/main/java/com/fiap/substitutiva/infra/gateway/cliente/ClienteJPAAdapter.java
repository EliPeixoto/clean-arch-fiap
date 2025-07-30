package com.fiap.substitutiva.infra.gateway.cliente;

import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.cliente.EditarCliente;
import com.fiap.substitutiva.application.usecase.cliente.RegistrarCliente;
import com.fiap.substitutiva.domain.model.Cliente;
import com.fiap.substitutiva.infra.persistence.cliente.ClienteRepository;

public class ClienteJPAAdapter implements
        BuscarClientePorId,
        EditarCliente,
        RegistrarCliente {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteJPAAdapter(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return mapper.toDomain(repository.save(mapper.toEntity(cliente)));
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return mapper.toDomain(repository.save(mapper.toEntity(cliente)));
    }
}
