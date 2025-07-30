package com.fiap.substitutiva.infra.controller.avaliacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.substitutiva.domain.model.Avaliacao;

public record AvaliacaoDTO(
        Long id,
        Long idCliente,
        int estrelas,
        String comentario,
        Long idEstabelecimento,
        Long idProfissional
) {

    public AvaliacaoDTO(Avaliacao avaliacao) {
        this(
                avaliacao.getId(),
                avaliacao.getIdCliente(),
                avaliacao.getEstrelas(),
                avaliacao.getComentario(),
                avaliacao.getIdEstabelecimento(),
                avaliacao.getIdProfissional()
        );
    }
}
