package com.fiap.substitutiva.application.usecase.foto.impl;

import com.fiap.substitutiva.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.fiap.substitutiva.domain.model.Foto;

import java.util.List;

public class BuscarFotosPorIdEstabelecimentoImpl {

    private final BuscarFotosPorIdEstabelecimento buscarFotosPorIdEstabelecimento;

    public BuscarFotosPorIdEstabelecimentoImpl(BuscarFotosPorIdEstabelecimento buscarFotosPorIdEstabelecimento) {
        this.buscarFotosPorIdEstabelecimento = buscarFotosPorIdEstabelecimento;
    }

    public List<Foto> buscarFotoPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarFotosPorIdEstabelecimento.buscarFotoPorIdEstabelecimento(idEstabelecimento);
    }
}
