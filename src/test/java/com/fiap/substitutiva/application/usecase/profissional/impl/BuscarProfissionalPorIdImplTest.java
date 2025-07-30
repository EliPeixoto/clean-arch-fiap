package com.fiap.substitutiva.application.usecase.profissional.impl;

import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.domain.model.Profissional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarProfissionalPorIdImplTest {

    private BuscarProfissionalPorId gateway;
    private BuscarProfissionalPorIdImpl useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(BuscarProfissionalPorId.class);
        useCase = new BuscarProfissionalPorIdImpl(gateway);
    }

    @Test
    void deveBuscarProfissionalPorId() {
        Long id = 1L;
        Profissional profissional = new Profissional();
        profissional.setId(id);

        when(gateway.buscarPorId(id)).thenReturn(profissional);

        Profissional resultado = useCase.buscarPorIdProfissional(id);

        assertEquals(id, resultado.getId());
        verify(gateway, times(1)).buscarPorId(id);
    }
}
