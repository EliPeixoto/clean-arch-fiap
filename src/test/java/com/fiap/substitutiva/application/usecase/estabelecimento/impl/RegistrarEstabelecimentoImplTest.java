package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.estabelecimento.RegistrarEstabelecimento;
import com.fiap.substitutiva.domain.model.Endereco;
import com.fiap.substitutiva.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrarEstabelecimentoImplTest {

    private RegistrarEstabelecimento registrarGateway;
    private BuscarEstabelecimentoPorId buscarEstabelecimento;
    private BuscarEnderecoPorIdEstabelecimento buscarEndereco;
    private RegistrarEstabelecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        registrarGateway = mock(RegistrarEstabelecimento.class);
        buscarEstabelecimento = mock(BuscarEstabelecimentoPorId.class);
        buscarEndereco = mock(BuscarEnderecoPorIdEstabelecimento.class);
        useCase = new RegistrarEstabelecimentoImpl(registrarGateway, buscarEstabelecimento, buscarEndereco);
    }

    @Test
    void deveRegistrarEstabelecimentoComEnderecoExistente() {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);
        Endereco endereco = new Endereco();
        endereco.setIdEstabelecimento(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(null);
        when(buscarEndereco.buscarPorIdEstabelecimento(1L)).thenReturn(endereco);
        when(registrarGateway.registrarEstabelecimento(estabelecimento)).thenReturn(estabelecimento);

        Estabelecimento resultado = useCase.registrarEstabelecimento(estabelecimento);

        assertEquals(estabelecimento, resultado);
        verify(registrarGateway).registrarEstabelecimento(estabelecimento);
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoJaExiste() {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);

        assertThrows(NoSuchElementException.class, () -> useCase.registrarEstabelecimento(estabelecimento));
        verifyNoInteractions(buscarEndereco, registrarGateway);
    }

}
