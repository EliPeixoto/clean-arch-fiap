package com.fiap.substitutiva.application.usecase.servico.impl;

import com.fiap.substitutiva.application.usecase.servico.ExcluirServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirServicoImplTest {

    private ExcluirServico excluirGateway;
    private ExcluirServicoImpl useCase;

    @BeforeEach
    void setUp() {
        excluirGateway = mock(ExcluirServico.class);
        useCase = new ExcluirServicoImpl(excluirGateway);
    }

    @Test
    void deveCancelarServicoPorId() {
        Long id = 1L;

        useCase.cancelar(id);

        verify(excluirGateway, times(1)).cancelarServico(id);
    }
}
