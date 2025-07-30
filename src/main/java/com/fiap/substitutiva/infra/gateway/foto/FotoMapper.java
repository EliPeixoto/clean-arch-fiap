package com.fiap.substitutiva.infra.gateway.foto;

import com.fiap.substitutiva.domain.model.Foto;
import com.fiap.substitutiva.infra.persistence.foto.FotoEntity;

public class FotoMapper {

    public Foto toDomain(FotoEntity in) {
        return new Foto(
        in.getId(),
        in.getNome(),
        in.getFoto(),
        in.getIdEstabelecimento()
        );
    }

    public FotoEntity toEntity(Foto in) {
        return new FotoEntity(
                in.getId(),
                in.getNome(),
                in.getFoto(),
                in.getIdEstabelecimento()
        );
    }
}
