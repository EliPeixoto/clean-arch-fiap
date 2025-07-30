package com.fiap.substitutiva.infra.config.avaliacao;

import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.fiap.substitutiva.application.usecase.avaliacao.*;
import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.avaliacao.BuscarAvaliacoesPorIdEstabelecimento;
import com.fiap.substitutiva.infra.gateway.avaliacao.AvaliacaoMapper;
import com.fiap.substitutiva.infra.persistence.avaliacao.AvaliacaoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class AvaliacaoConfigTest {

    private final AvaliacaoConfig config = new AvaliacaoConfig();

    @Test
    void deveInstanciarAvaliarEstabelecimentoImpl() {
        var usecase = config.avaliarEstabelecimento(
                mock(AvaliarEstabelecimento.class),
                mock(BuscarClientePorId.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarAgendamentosPorCliente.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarAvaliarProfissionalImpl() {
        var usecase = config.avaliarProfissional(
                mock(AvaliarProfissional.class),
                mock(BuscarClientePorId.class),
                mock(BuscarProfissionalPorId.class),
                mock(BuscarAgendamentosPorCliente.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarBuscarAvaliacoesPorIdClienteImpl() {
        var usecase = config.buscarAvaliacoesPorIdCliente(mock(BuscarAvaliacoesPorIdCliente.class));
        assertNotNull(usecase);
    }



    @Test
    void deveInstanciarEditarAvaliacaoImpl() {
        var usecase = config.editarAvaliacao(
                mock(EditarAvaliacao.class),
                mock(BuscarAvaliacaoPorId.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarExcluirAvaliacaoImpl() {
        var usecase = config.excluirAvaliacao(mock(ExcluirAvaliacao.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarAvaliacaoJPAAdapter() {
        var usecase = config.avaliacaoJPAAdapter(
                mock(AvaliacaoRepository.class),
                new AvaliacaoMapper()
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarAvaliacaoMapper() {
        var usecase = config.avaliacaoMapper();
        assertNotNull(usecase);
    }
}
