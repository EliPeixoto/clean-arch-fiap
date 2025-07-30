package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarEstabelecimentoPorIdImplTest {

    private BuscarEstabelecimentoPorId gateway;
    private BuscarEstabelecimentoPorIdImpl useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(BuscarEstabelecimentoPorId.class);
        useCase = new BuscarEstabelecimentoPorIdImpl(gateway);
    }

    @Test
    void deveBuscarEstabelecimentoPorId() {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(gateway.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);

        Estabelecimento resultado = useCase.buscarEstabelecimentoPorId(1L);

        assertEquals(1L, resultado.getId());
        verify(gateway, times(1)).buscarEstabelecimentoPorId(1L);
    }
}
