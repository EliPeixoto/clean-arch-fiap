package com.fiap.substitutiva.domain.gateway;

import com.fiap.substitutiva.domain.model.Agendamento;

import java.time.LocalDate;
import java.util.List;

public interface AgendamentoGateway {
    Agendamento buscarPorId(Long id);
    Agendamento salvar(Agendamento agendamento);
    List<Agendamento> buscarPorProfissionalEDia(Long idProfissional, LocalDate data);
}
