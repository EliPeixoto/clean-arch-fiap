package com.fiap.substitutiva.infra.controller.profissional;

import com.fiap.substitutiva.domain.model.Profissional;

public record ProfissionalDTO(
        Long id,
        String nome,
        String email,
        String especialidade,
        Integer tarifaPorHora,
        Long idEstabelecimento
) {

    public ProfissionalDTO(Profissional profissional){
        this(
        profissional.getId(),
        profissional.getNome(),
        profissional.getEmail(),
        profissional.getEspecialidade(),
        profissional.getTarifaPorHora(),
        profissional.getIdEstabelecimento()
        );
    }
}
