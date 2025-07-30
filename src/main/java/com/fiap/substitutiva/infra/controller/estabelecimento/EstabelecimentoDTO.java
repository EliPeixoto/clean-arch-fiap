package com.fiap.substitutiva.infra.controller.estabelecimento;

import com.fiap.substitutiva.domain.model.Estabelecimento;

public record EstabelecimentoDTO(
        Long id,
        String nome,
        Long idEndereco,
        String email
) {

    public EstabelecimentoDTO(Estabelecimento estabelecimento){
        this(
        estabelecimento.getId(),
        estabelecimento.getNome(),
        estabelecimento.getIdEndereco(),
        estabelecimento.getEmail()
        );
    }
}
