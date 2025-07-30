package com.fiap.substitutiva.infra.config.cliente;

import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.cliente.EditarCliente;
import com.fiap.substitutiva.application.usecase.cliente.RegistrarCliente;
import com.fiap.substitutiva.infra.gateway.cliente.ClienteMapper;
import com.fiap.substitutiva.infra.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ClienteConfigTest {

    private final ClienteConfig config = new ClienteConfig();

    @Test
    void deveInstanciarBuscarClientePorIdImpl() {
        var usecase = config.buscarClientePorId(mock(BuscarClientePorId.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarEditarClienteImpl() {
        var usecase = config.editarCliente(
                mock(EditarCliente.class),
                mock(BuscarClientePorId.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarRegistrarClienteImpl() {
        var usecase = config.registrarCliente(mock(RegistrarCliente.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarClienteJPAAdapter() {
        var usecase = config.clienteJPAAdapter(
                mock(ClienteRepository.class),
                new ClienteMapper()
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarClienteMapper() {
        var mapper = config.clienteMapper();
        assertNotNull(mapper);
    }
}
