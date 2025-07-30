package com.fiap.substitutiva.application.usecase.agendamento;

import com.fiap.substitutiva.domain.model.Agendamento;

import java.time.LocalDate;
import java.util.List;

public interface BuscarAgendamentosPorProfissionalEDia {
    List<Agendamento> buscarAgendamentos(Long idProfissional, LocalDate data);
}
