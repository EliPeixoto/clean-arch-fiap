package com.fiap.substitutiva.application.usecase.agendamento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.fiap.substitutiva.application.usecase.agendamento.RealizarAgendamento;
import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.horario.BuscarHorarioPorDia;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.servico.BuscarServicoPorId;
import com.fiap.substitutiva.domain.model.*;
import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import com.fiap.substitutiva.domain.model.constant.StatusEnum;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class RealizarAgendamentoImpl {
    private final RealizarAgendamento realizarAgendamento;
    private final BuscarClientePorId buscarClientePorId;
    private final BuscarProfissionalPorId buscarProfissionalPorId;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarServicoPorId buscarServicoPorId;
    private final BuscarHorarioPorDia buscarHorarioPorDia;
    private final BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia;

    public RealizarAgendamentoImpl(RealizarAgendamento realizarAgendamento, BuscarClientePorId buscarClientePorId, BuscarProfissionalPorId buscarProfissionalPorId, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarServicoPorId buscarServicoPorId, BuscarHorarioPorDia buscarHorarioPorDia, BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        this.realizarAgendamento = realizarAgendamento;
        this.buscarClientePorId = buscarClientePorId;
        this.buscarProfissionalPorId = buscarProfissionalPorId;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarServicoPorId = buscarServicoPorId;
        this.buscarHorarioPorDia = buscarHorarioPorDia;
        this.buscarAgendamentosPorProfissionalEDia = buscarAgendamentosPorProfissionalEDia;
    }

    public Agendamento realizarAgendamento(Agendamento agendamento) {
        if (Objects.isNull(buscarClientePorId.buscarClientePorId(agendamento.getIdCliente()))) {
            throw new NoSuchElementException("Cliente não encontrato");
        }

        Profissional profissional = buscarProfissionalPorId.buscarPorId(agendamento.getIdProfissional());
        if (Objects.isNull(profissional)) {
            throw new NoSuchElementException("Profissional não encontrado");
        }

        Estabelecimento estabelecimento = buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(agendamento.getIdEstabelecimento());
        if (Objects.isNull(estabelecimento)) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }

        Servico servico = buscarServicoPorId.buscarServicoPorId(agendamento.getIdServico());
        if (Objects.isNull(servico)) {
            throw new NoSuchElementException("Serviço não encontrado");
        }

        if (!profissional.getIdEstabelecimento().equals(estabelecimento.getId())
        || !servico.getIdEstabelecimento().equals(estabelecimento.getId())) {
            throw new IllegalStateException("O profissional ou o serviço não está vinculado ao estabelecimento fornecido");
        }

        if(!temDataHoraDisponivel(agendamento, estabelecimento)) {
            throw new IllegalStateException("Há um conflito com o horário de inicio e/ou término do agendamento");
        }

        agendamento.setStatus(StatusEnum.AGENDADO);
        return realizarAgendamento.agendar(agendamento);
    }

    private boolean temDataHoraDisponivel(Agendamento agendamento, Estabelecimento estabelecimento) {
        String dayOfWeek = agendamento.getData().getDayOfWeek().toString();
        Horario horarioDoEstabelecimento = buscarHorarioPorDia.buscarHorarioPorDia(
                estabelecimento.getId(),
                DiasDaSemanaEnum.valueOf(dayOfWeek)
        );

        if (horarioDoEstabelecimento != null &&
                (agendamento.getHoraInicio().isBefore(horarioDoEstabelecimento.getInicio())
                        || agendamento.getHoraTermino().isAfter(horarioDoEstabelecimento.getFim()))) {
            return false;
        }

        List<Agendamento> agendamentosNoDia = buscarAgendamentosPorProfissionalEDia.buscarAgendamentos(
                agendamento.getIdProfissional(),
                agendamento.getData()
        );

        if (agendamentosNoDia == null) {
            agendamentosNoDia = List.of();
        }

        return agendamentosNoDia.stream()
                .noneMatch(agendamentoExistente ->
                        agendamento.getHoraInicio().isBefore(agendamentoExistente.getHoraTermino()) &&
                                agendamento.getHoraTermino().isAfter(agendamentoExistente.getHoraInicio()));
    }

}
