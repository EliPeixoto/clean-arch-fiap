package com.fiap.substitutiva.application.usecase.horario.impl;

import com.fiap.substitutiva.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.fiap.substitutiva.domain.model.Horario;

import java.util.List;

public class BuscarHorariosPorIdEstabelecimentoImpl {

    private final BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento;

    public BuscarHorariosPorIdEstabelecimentoImpl(BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento) {
        this.buscarHorariosPorIdEstabelecimento = buscarHorariosPorIdEstabelecimento;
    }

    public List<Horario> buscarHorariosPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarHorariosPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
    }
}
