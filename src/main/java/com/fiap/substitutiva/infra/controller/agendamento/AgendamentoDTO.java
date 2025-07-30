package com.fiap.substitutiva.infra.controller.agendamento;

import com.fiap.substitutiva.domain.model.Agendamento;
import com.fiap.substitutiva.domain.model.constant.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoDTO(
        Long id,
        Long idProfissional,
        Long idEstabelecimento,
        Long idCliente,
        Long idServico,
        StatusEnum status,
        LocalDate data,
        @Schema(type = "string", example = "08:45", pattern = "HH:mm")
        LocalTime horaInicio,
        @Schema(type = "string", example = "09:45", pattern = "HH:mm")
        LocalTime horaTermino
) {

    public AgendamentoDTO(Agendamento agendamento) {
        this(
        agendamento.getId(),
        agendamento.getIdProfissional(),
        agendamento.getIdEstabelecimento(),
        agendamento.getIdCliente(),
        agendamento.getIdServico(),
        agendamento.getStatus(),
        agendamento.getData(),
        agendamento.getHoraInicio(),
        agendamento.getHoraTermino()
        );
    }
}
