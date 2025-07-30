package com.fiap.substitutiva.infra.gateway.horario;

import com.fiap.substitutiva.domain.model.Horario;
import com.fiap.substitutiva.infra.persistence.horario.HorarioEntity;

public class HorarioMapper {

    public Horario toDomain(HorarioEntity in) {
        return new Horario(
        in.getId(),
        in.getDiaDaSemana(),
        in.getInicio(),
        in.getFim(),
        in.getIdEstabelecimento()
        );
    }

    public HorarioEntity toEntity(Horario in) {
        return new HorarioEntity(
                in.getId(),
                in.getDiaDaSemana(),
                in.getInicio(),
                in.getFim(),
                in.getIdEstabelecimento()
        );
    }
}
