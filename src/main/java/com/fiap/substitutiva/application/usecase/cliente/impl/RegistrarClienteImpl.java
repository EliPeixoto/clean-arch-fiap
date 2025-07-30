package com.fiap.substitutiva.application.usecase.cliente.impl;

import com.fiap.substitutiva.application.usecase.cliente.RegistrarCliente;
import com.fiap.substitutiva.domain.model.Cliente;

public class RegistrarClienteImpl {

    private final RegistrarCliente registrarCliente;

    public RegistrarClienteImpl(RegistrarCliente registrarCliente) {
        this.registrarCliente = registrarCliente;
    }

    public Cliente registrarCliente(Cliente cliente) {
        cliente.setId(null);
        return registrarCliente.registrarCliente(cliente);
    }
}
