package com.fiap.substitutiva.application.usecase.cliente.impl;

import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.cliente.EditarCliente;
import com.fiap.substitutiva.domain.model.Cliente;

import java.util.NoSuchElementException;
import java.util.Objects;

public class EditarClienteImpl {

    private final EditarCliente editarCliente;
    private final BuscarClientePorId buscarClientePorId;

    public EditarClienteImpl(EditarCliente editarCliente, BuscarClientePorId buscarClientePorId) {
        this.editarCliente = editarCliente;
        this.buscarClientePorId = buscarClientePorId;
    }

    public Cliente editar(Cliente cliente) {
        if(Objects.isNull(cliente.getId())){
            throw new IllegalStateException("ID não pode ser nulo");
        }
        if(Objects.isNull(buscarClientePorId.buscarClientePorId(cliente.getId()))){
            throw new NoSuchElementException("Não foi possível encontrar o cliente");
        }
        return editarCliente.editarCliente(cliente);
    }
}
