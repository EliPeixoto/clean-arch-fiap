package com.fiap.substitutiva.application.usecase.agendamento.impl;

import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentoPorId;
import com.fiap.substitutiva.application.usecase.agendamento.CancelarAgendamento;
import com.fiap.substitutiva.domain.model.Agendamento;
import com.fiap.substitutiva.domain.model.constant.StatusEnum;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CancelarAgendamentoImpl {
    private final CancelarAgendamento cancelarAgendamento;
    private final BuscarAgendamentoPorId buscarAgendamentoPorId;

    public CancelarAgendamentoImpl(CancelarAgendamento cancelarAgendamento, BuscarAgendamentoPorId buscarAgendamentoPorId) {
        this.cancelarAgendamento = cancelarAgendamento;
        this.buscarAgendamentoPorId = buscarAgendamentoPorId;
    }

    public Agendamento cancelar(Long idAgendamento) {
        Agendamento agendamento = buscarAgendamentoPorId.buscarAgendamentoPorId(idAgendamento);
        if (Objects.isNull(agendamento)) {
            throw new NoSuchElementException("Não foi possível encontrar o agendamento");
        }
        if (agendamento.getStatus().equals(StatusEnum.CANCELADO)
                || agendamento.getStatus().equals(StatusEnum.CONCLUIDO)) {
            throw new IllegalStateException("Não é possível cancelar um agendamento já cancelado ou concluído");
        }
        agendamento.setStatus(StatusEnum.CANCELADO);
        return cancelarAgendamento.cancelar(agendamento);
    }
}
