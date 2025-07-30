package com.fiap.substitutiva.application.usecase.horario;

import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import com.fiap.substitutiva.domain.model.Horario;

public interface BuscarHorarioPorDia {
    Horario buscarHorarioPorDia(Long idEstabelecimento, DiasDaSemanaEnum dia);
}
