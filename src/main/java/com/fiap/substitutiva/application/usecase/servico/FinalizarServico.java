package com.fiap.substitutiva.application.usecase.servico;

import com.fiap.substitutiva.domain.model.Agendamento;

public interface FinalizarServico {
    Agendamento finalizarServico(Long idAgendamento);
}
