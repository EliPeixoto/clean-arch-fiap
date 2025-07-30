package com.fiap.substitutiva.application.usecase.horario;

import com.fiap.substitutiva.domain.model.Horario;

import java.util.List;

public interface BuscarHorariosPorIdEstabelecimento {

    List<Horario> buscarPorIdEstabelecimento(Long idEstabelecimento);
}
