package com.fiap.substitutiva.infra.controller.foto;

import com.fiap.substitutiva.domain.model.Foto;

public record FotoDTO(
        Long id,
        String nome,
        String foto,
        Long idEstabelecimento
) {

    public FotoDTO(Foto foto){
        this(
        foto.getId(),
        foto.getNome(),
        foto.getFoto(),
        foto.getIdEstabelecimento()
        );
    }
}
