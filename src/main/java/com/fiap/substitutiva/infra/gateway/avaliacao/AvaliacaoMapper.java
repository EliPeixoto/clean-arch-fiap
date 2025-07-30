package com.fiap.substitutiva.infra.gateway.avaliacao;

import com.fiap.substitutiva.domain.model.Avaliacao;
import com.fiap.substitutiva.infra.persistence.avaliacao.AvaliacaoEntity;

public class AvaliacaoMapper {

    public Avaliacao toDomain(AvaliacaoEntity in) {
        return new Avaliacao(
                in.getId(),
                in.getIdCliente(),
                in.getEstrelas(),
                in.getComentario(),
                in.getIdEstabelecimento(),
                in.getIdProfissional()
        );
    }

    public AvaliacaoEntity toEntity(Avaliacao in) {
        return new AvaliacaoEntity(
                in.getId(),
                in.getIdCliente(),
                in.getEstrelas(),
                in.getComentario(),
                in.getIdEstabelecimento(),
                in.getIdProfissional()
        );
    }
}
