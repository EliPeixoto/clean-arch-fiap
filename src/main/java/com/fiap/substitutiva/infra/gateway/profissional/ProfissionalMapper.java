package com.fiap.substitutiva.infra.gateway.profissional;

import com.fiap.substitutiva.domain.model.Profissional;
import com.fiap.substitutiva.infra.persistence.profissional.ProfissionalEntity;

public class ProfissionalMapper {

    public Profissional toDomain(ProfissionalEntity in) {
        return new Profissional(
        in.getId(),
        in.getNome(),
        in.getEmail(),
        in.getEspecialidade(),
        in.getTarifaPorHora(),
        in.getIdEstabelecimento()
        );
    }

    public ProfissionalEntity toEntity (Profissional in) {
        return new ProfissionalEntity(
                in.getId(),
                in.getNome(),
                in.getEmail(),
                in.getEspecialidade(),
                in.getTarifaPorHora(),
                in.getIdEstabelecimento()
        );
    }
}
