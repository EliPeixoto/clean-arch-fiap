package com.fiap.substitutiva.infra.gateway.foto;

import com.fiap.substitutiva.application.usecase.foto.AdicionarFoto;
import com.fiap.substitutiva.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.foto.ExcluirFoto;
import com.fiap.substitutiva.domain.model.Foto;
import com.fiap.substitutiva.infra.persistence.foto.FotoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FotoJPAAdapter implements
        AdicionarFoto,
        BuscarFotosPorIdEstabelecimento,
        ExcluirFoto {

    private final FotoRepository repository;
    private final FotoMapper mapper;

    @Override
    public Foto adicionarFoto(Foto foto) {
        return mapper.toDomain(repository.save(mapper.toEntity(foto)));
    }

    @Override
    public List<Foto> buscarFotoPorIdEstabelecimento(Long idEstabelecimento) {
        return repository.findByIdEstabelecimento(idEstabelecimento).stream().map(mapper::toDomain).toList();
    }

    @Override
    public void excluirFoto(Long id) {
        repository.deleteById(id);
    }
}
