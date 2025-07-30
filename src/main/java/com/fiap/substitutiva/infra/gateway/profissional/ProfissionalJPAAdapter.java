package com.fiap.substitutiva.infra.gateway.profissional;

import com.fiap.substitutiva.application.usecase.profissional.AdmitirProfissional;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.profissional.EditarProfissional;
import com.fiap.substitutiva.application.usecase.profissional.RegistrarProfissional;
import com.fiap.substitutiva.domain.model.Profissional;
import com.fiap.substitutiva.infra.persistence.profissional.ProfissionalRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfissionalJPAAdapter implements
        AdmitirProfissional,
        BuscarProfissionalPorId,
        EditarProfissional,
        RegistrarProfissional {

    private final ProfissionalRepository repository;
    private final ProfissionalMapper mapper;

    @Override
    public Profissional admitirProfissional(Profissional profissional) {
        return mapper.toDomain(repository.save(mapper.toEntity(profissional)));
    }

    @Override
    public Profissional buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Profissional demitir(Profissional profissional) {
        return mapper.toDomain(repository.save(mapper.toEntity(profissional)));
    }

    @Override
    public Profissional registrar(Profissional profissional) {
        return mapper.toDomain(repository.save(mapper.toEntity(profissional)));
    }
}
