package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.estabelecimento.RegistrarEstabelecimento;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RegistrarEstabelecimentoImpl {

    private final RegistrarEstabelecimento registrarEstabelecimento;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento;

    public RegistrarEstabelecimentoImpl(RegistrarEstabelecimento registrarEstabelecimento, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        this.registrarEstabelecimento = registrarEstabelecimento;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarEnderecoPorIdEstabelecimento = buscarEnderecoPorIdEstabelecimento;
    }

    public Estabelecimento registrarEstabelecimento(Estabelecimento estabelecimento) {
        if (Objects.nonNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(estabelecimento.getId()))) {
            throw new NoSuchElementException("Estabelecimento já registrado");
        }
        return registrarEstabelecimento.registrarEstabelecimento(estabelecimento);
    }
}
