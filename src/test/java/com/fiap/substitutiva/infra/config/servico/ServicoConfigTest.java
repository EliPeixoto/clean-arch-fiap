package com.fiap.substitutiva.infra.config.servico;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.servico.BuscarPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.servico.ExcluirServico;
import com.fiap.substitutiva.application.usecase.servico.RegistrarServico;
import com.fiap.substitutiva.infra.gateway.servico.ServicoMapper;
import com.fiap.substitutiva.infra.persistence.servico.ServicoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ServicoConfigTest {

    private final ServicoConfig config = new ServicoConfig();

    @Test
    void deveInstanciarBuscarPorIdEstabelecimentoImpl() {
        var bean = config.buscarPorIdEstabelecimento(mock(BuscarPorIdEstabelecimento.class));
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarExcluirServicoImpl() {
        var bean = config.excluirServico(mock(ExcluirServico.class));
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarRegistrarServicoImpl() {
        var bean = config.registrarServico(
                mock(RegistrarServico.class),
                mock(BuscarEstabelecimentoPorId.class)
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarServicoJPAAdapter() {
        var bean = config.servicoJPAAdapter(
                mock(ServicoRepository.class),
                new ServicoMapper()
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarServicoMapper() {
        assertNotNull(config.servicoMapper());
    }
}
