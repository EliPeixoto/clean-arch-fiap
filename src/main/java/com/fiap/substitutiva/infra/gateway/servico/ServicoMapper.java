package com.fiap.substitutiva.infra.gateway.servico;

import com.fiap.substitutiva.domain.model.Servico;
import com.fiap.substitutiva.infra.persistence.servico.ServicoEntity;

public class ServicoMapper {

    public Servico toDomain(ServicoEntity in) {
        return new Servico(
        in.getId(),
        in.getNome(),
        in.getValor(),
        in.getIdEstabelecimento()
        );
    }

    public ServicoEntity toEntity(Servico in) {
        return new ServicoEntity(
                in.getId(),
                in.getNome(),
                in.getValor(),
                in.getIdEstabelecimento()
        );
    }
}
