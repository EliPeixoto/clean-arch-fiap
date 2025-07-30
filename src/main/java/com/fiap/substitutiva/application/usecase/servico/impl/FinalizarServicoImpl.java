package com.fiap.substitutiva.application.usecase.servico.impl;

import com.fiap.substitutiva.application.usecase.servico.FinalizarServico;
import com.fiap.substitutiva.domain.gateway.AgendamentoGateway;
import com.fiap.substitutiva.domain.model.Agendamento;
import com.fiap.substitutiva.domain.model.constant.StatusEnum;

import java.util.NoSuchElementException;

public class FinalizarServicoImpl implements FinalizarServico {
    private final AgendamentoGateway agendamentoGateway;

    public FinalizarServicoImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento finalizarServico(Long idAgendamento) {
        Agendamento agendamento = agendamentoGateway.buscarPorId(idAgendamento);


        if (!agendamento.getStatus().equals(StatusEnum.AGENDADO)) {
            throw new NoSuchElementException("Agendamento não está em status AGENDADO");
        }

        agendamento.setStatus(StatusEnum.CONCLUIDO);
        return agendamentoGateway.salvar(agendamento);
    }
}
