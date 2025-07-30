package com.fiap.substitutiva.application.usecase.endereco;

import com.fiap.substitutiva.domain.model.Endereco;

public interface BuscarEnderecoPorIdEstabelecimento {
    Endereco buscarPorIdEstabelecimento(Long id);
}
