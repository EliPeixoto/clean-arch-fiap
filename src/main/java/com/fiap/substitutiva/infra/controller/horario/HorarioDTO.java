package com.fiap.substitutiva.infra.controller.horario;

import com.fiap.substitutiva.domain.model.Horario;
import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalTime;

public record HorarioDTO(
        Long id,
        DiasDaSemanaEnum diaDaSemana,
        @Schema(type = "string", example = "08:30", pattern = "HH:mm")
        LocalTime inicio,
        @Schema(type = "string", example = "18:00", pattern = "HH:mm")
        LocalTime fim,
        Long idEstabelecimento
) {

    public HorarioDTO(Horario horario) {
        this(
                horario.getId(),
                horario.getDiaDaSemana(),
                horario.getInicio(),
                horario.getFim(),
                horario.getIdEstabelecimento()
        );
    }
}
