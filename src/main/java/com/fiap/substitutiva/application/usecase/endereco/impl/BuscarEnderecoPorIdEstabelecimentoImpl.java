package com.fiap.substitutiva.application.usecase.endereco.impl;

import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.fiap.substitutiva.domain.model.Endereco;

import java.util.NoSuchElementException;
import java.util.Objects;

public class BuscarEnderecoPorIdEstabelecimentoImpl {

    private final BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento;

    public BuscarEnderecoPorIdEstabelecimentoImpl(BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        this.buscarEnderecoPorIdEstabelecimento = buscarEnderecoPorIdEstabelecimento;
    }

    public Endereco buscarPorIdEstabelecimento(Long idEstabelecimento) {
        Endereco endereco = buscarEnderecoPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
        if(Objects.isNull(endereco)) {
            throw new NoSuchElementException("Não foi possível encontrar o endereço");
        }
        return endereco;
    }
}
