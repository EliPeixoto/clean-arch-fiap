package com.fiap.substitutiva.application.usecase.endereco.impl;

import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.endereco.RegistrarEndereco;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.domain.model.Endereco;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RegistrarEnderecoImpl {

    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final RegistrarEndereco registrarEndereco;
    private final BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento;

    public RegistrarEnderecoImpl(BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, RegistrarEndereco registrarEndereco, BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.registrarEndereco = registrarEndereco;
        this.buscarEnderecoPorIdEstabelecimento = buscarEnderecoPorIdEstabelecimento;
    }

    public Endereco registrarEndereco(Endereco endereco) {
        Estabelecimento estabelecimento = buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(endereco.getIdEstabelecimento());
        if (Objects.isNull(estabelecimento)) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }
        if (Objects.nonNull(buscarEnderecoPorIdEstabelecimento.buscarPorIdEstabelecimento(endereco.getIdEstabelecimento()))) {
            throw new IllegalStateException("Este estabelecimento já contém um endereço");
        }
        if (!endereco.isValid()) {
            throw new IllegalStateException("Dados obrigatórios estão nulos, preencha-os corretamente");
        }
        return registrarEndereco.registrarEndereco(endereco);
    }
}
