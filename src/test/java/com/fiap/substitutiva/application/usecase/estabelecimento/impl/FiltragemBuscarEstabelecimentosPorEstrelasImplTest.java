package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.avaliacao.VerTodasAsAvaliacoes;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.domain.model.Avaliacao;
import com.fiap.substitutiva.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiltragemBuscarEstabelecimentosPorEstrelasImplTest {

    private VerTodasAsAvaliacoes verTodasAsAvaliacoes;
    private BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private FiltragemBuscarEstabelecimentosPorEstrelasImpl useCase;

    @BeforeEach
    void setUp() {
        verTodasAsAvaliacoes = mock(VerTodasAsAvaliacoes.class);
        buscarEstabelecimentoPorId = mock(BuscarEstabelecimentoPorId.class);
        useCase = new FiltragemBuscarEstabelecimentosPorEstrelasImpl(verTodasAsAvaliacoes, buscarEstabelecimentoPorId);
    }

    @Test
    void deveRetornarEstabelecimentosComNotaCinco() {
        Avaliacao a1 = new Avaliacao();
        a1.setIdEstabelecimento(1L);
        a1.setEstrelas(5);

        Estabelecimento e1 = new Estabelecimento();
        e1.setId(1L);

        when(verTodasAsAvaliacoes.verTodasAsAvaliacoes()).thenReturn(List.of(a1));
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(1L)).thenReturn(e1);

        List<Estabelecimento> resultado = useCase.listaEstabelecimentosPorEstrelas(5);

        assertEquals(1, resultado.size());
        assertEquals(1L, resultado.get(0).getId());
    }

    @Test
    void deveRetornarEstabelecimentosComNotaEntreQuatroEQuatroPontoNoventaNove() {
        Avaliacao a1 = new Avaliacao();
        a1.setIdEstabelecimento(1L);
        a1.setEstrelas(4);

        Avaliacao a2 = new Avaliacao();
        a2.setIdEstabelecimento(1L);
        a2.setEstrelas(5);

        Estabelecimento e1 = new Estabelecimento();
        e1.setId(1L);

        when(verTodasAsAvaliacoes.verTodasAsAvaliacoes()).thenReturn(List.of(a1));
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(1L)).thenReturn(e1);

        List<Estabelecimento> resultado = useCase.listaEstabelecimentosPorEstrelas(4);

        assertEquals(1, resultado.size());
        assertEquals(1L, resultado.get(0).getId());
    }

    @Test
    void deveIgnorarEstabelecimentosQueLancamExcecaoNaBusca() {
        Avaliacao a1 = new Avaliacao();
        a1.setIdEstabelecimento(1L);
        a1.setEstrelas(5);

        when(verTodasAsAvaliacoes.verTodasAsAvaliacoes()).thenReturn(List.of(a1));
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(1L)).thenThrow(new NoSuchElementException());

        List<Estabelecimento> resultado = useCase.listaEstabelecimentosPorEstrelas(5);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaAvaliacoes() {
        when(verTodasAsAvaliacoes.verTodasAsAvaliacoes()).thenReturn(List.of());

        List<Estabelecimento> resultado = useCase.listaEstabelecimentosPorEstrelas(3);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}
