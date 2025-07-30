package com.fiap.substitutiva.infra.config.agendamento;

import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentoPorId;
import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.fiap.substitutiva.application.usecase.agendamento.CancelarAgendamento;
import com.fiap.substitutiva.application.usecase.agendamento.RealizarAgendamento;
import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.horario.BuscarHorarioPorDia;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.servico.BuscarServicoPorId;
import com.fiap.substitutiva.infra.gateway.agendamento.AgendamentoMapper;
import com.fiap.substitutiva.infra.persistence.agendamento.AgendamentoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgendamentoConfigTest {

    private final AgendamentoConfig config = new AgendamentoConfig();

    @Test
    void deveInstanciarBuscarAgendamentosPorProfissionalEDiaImpl() {
        BuscarAgendamentosPorProfissionalEDia mock = mock(BuscarAgendamentosPorProfissionalEDia.class);
        var result = config.buscarAgendamentosPorProfissionalEDia(mock);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarCancelarAgendamentoImpl() {
        CancelarAgendamento cancelar = mock(CancelarAgendamento.class);
        BuscarAgendamentoPorId buscar = mock(BuscarAgendamentoPorId.class);
        var result = config.cancelarAgendamento(cancelar, buscar);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarRealizarAgendamentoImpl() {
        RealizarAgendamento realizar = mock(RealizarAgendamento.class);
        BuscarClientePorId cliente = mock(BuscarClientePorId.class);
        BuscarProfissionalPorId profissional = mock(BuscarProfissionalPorId.class);
        BuscarEstabelecimentoPorId est = mock(BuscarEstabelecimentoPorId.class);
        BuscarServicoPorId servico = mock(BuscarServicoPorId.class);
        BuscarHorarioPorDia horario = mock(BuscarHorarioPorDia.class);
        BuscarAgendamentosPorProfissionalEDia buscar = mock(BuscarAgendamentosPorProfissionalEDia.class);
        var result = config.realizarAgendamento(realizar, cliente, profissional, est, servico, horario, buscar);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarAgendamentoJPAAdapter() {
        AgendamentoRepository repo = mock(AgendamentoRepository.class);
        AgendamentoMapper mapper = new AgendamentoMapper();
        var result = config.agendamentoJPAAdapter(repo, mapper);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarAgendamentoMapper() {
        var result = config.agendamentoMapper();
        assertNotNull(result);
    }
}
