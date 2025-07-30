package com.fiap.substitutiva.infra.controller.servico;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.substitutiva.domain.model.Servico;

public record ServicoDTO(
        Long id,
        String nome,
        int valor,
        Long idEstabelecimento
) {

    public ServicoDTO(Servico servico) {
        this(
                servico.getId(),
                servico.getNome(),
                servico.getValor(),
                servico.getIdEstabelecimento()
        );
    }
}
