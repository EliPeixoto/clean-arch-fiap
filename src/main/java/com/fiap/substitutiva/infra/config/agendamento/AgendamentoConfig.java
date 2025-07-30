package com.fiap.substitutiva.infra.config.agendamento;

import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentoPorId;
import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.fiap.substitutiva.application.usecase.agendamento.CancelarAgendamento;
import com.fiap.substitutiva.application.usecase.agendamento.RealizarAgendamento;
import com.fiap.substitutiva.application.usecase.agendamento.impl.BuscarAgendamentosPorProfissionalEDiaImpl;
import com.fiap.substitutiva.application.usecase.agendamento.impl.CancelarAgendamentoImpl;
import com.fiap.substitutiva.application.usecase.agendamento.impl.RealizarAgendamentoImpl;
import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.horario.BuscarHorarioPorDia;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.servico.BuscarServicoPorId;
import com.fiap.substitutiva.infra.gateway.agendamento.AgendamentoJPAAdapter;
import com.fiap.substitutiva.infra.gateway.agendamento.AgendamentoMapper;
import com.fiap.substitutiva.infra.persistence.agendamento.AgendamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgendamentoConfig {

    @Bean
    BuscarAgendamentosPorProfissionalEDiaImpl buscarAgendamentosPorProfissionalEDia(BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        return new BuscarAgendamentosPorProfissionalEDiaImpl(buscarAgendamentosPorProfissionalEDia);
    }

    @Bean
    CancelarAgendamentoImpl cancelarAgendamento(CancelarAgendamento cancelarAgendamento, BuscarAgendamentoPorId buscarAgendamentoPorId) {
        return new CancelarAgendamentoImpl(cancelarAgendamento, buscarAgendamentoPorId);
    }

    @Bean
    RealizarAgendamentoImpl realizarAgendamento(RealizarAgendamento realizarAgendamento,
                                                BuscarClientePorId buscarClientePorId,
                                                BuscarProfissionalPorId buscarProfissionalPorId,
                                                BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                BuscarServicoPorId buscarServicoPorId,
                                                BuscarHorarioPorDia buscarHorarioPorDia,
                                                BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        return new RealizarAgendamentoImpl(realizarAgendamento,
                buscarClientePorId,
                buscarProfissionalPorId,
                buscarEstabelecimentoPorId,
                buscarServicoPorId,
                buscarHorarioPorDia,
                buscarAgendamentosPorProfissionalEDia
        );
    }

    @Bean
    AgendamentoJPAAdapter agendamentoJPAAdapter(AgendamentoRepository repository, AgendamentoMapper mapper) {
        return new AgendamentoJPAAdapter(repository, mapper);
    }

    @Bean
    AgendamentoMapper agendamentoMapper(){
        return new AgendamentoMapper();
    }
}
