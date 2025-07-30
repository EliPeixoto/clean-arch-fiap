package com.fiap.substitutiva.application.usecase.agendamento;

import com.fiap.substitutiva.domain.model.Agendamento;

public interface CancelarAgendamento {
    Agendamento cancelar(Agendamento agendamento);
}
