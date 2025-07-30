package com.fiap.substitutiva.infra.config.cliente;

import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.cliente.EditarCliente;
import com.fiap.substitutiva.application.usecase.cliente.RegistrarCliente;
import com.fiap.substitutiva.application.usecase.cliente.impl.BuscarClientePorIdImpl;
import com.fiap.substitutiva.application.usecase.cliente.impl.EditarClienteImpl;
import com.fiap.substitutiva.application.usecase.cliente.impl.RegistrarClienteImpl;
import com.fiap.substitutiva.infra.gateway.cliente.ClienteJPAAdapter;
import com.fiap.substitutiva.infra.gateway.cliente.ClienteMapper;
import com.fiap.substitutiva.infra.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    public BuscarClientePorIdImpl buscarClientePorId(BuscarClientePorId buscarClientePorId) {
        return new BuscarClientePorIdImpl(buscarClientePorId);
    }

    @Bean
    public EditarClienteImpl editarCliente(EditarCliente editarCliente, BuscarClientePorId buscarClientePorId) {
        return new EditarClienteImpl(editarCliente, buscarClientePorId);
    }

    @Bean
    public RegistrarClienteImpl registrarCliente(RegistrarCliente registrarCliente) {
        return new RegistrarClienteImpl(registrarCliente);
    }

    @Bean
    public ClienteJPAAdapter clienteJPAAdapter(ClienteRepository repository, ClienteMapper mapper) {
        return new ClienteJPAAdapter(repository, mapper);
    }

    @Bean
    ClienteMapper clienteMapper() {
        return new ClienteMapper();
    }
}
