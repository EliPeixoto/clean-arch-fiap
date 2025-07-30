package com.fiap.substitutiva.infra.gateway.horario;

import com.fiap.substitutiva.application.usecase.horario.BuscarHorarioPorDia;
import com.fiap.substitutiva.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.horario.CadastrarHorario;
import com.fiap.substitutiva.application.usecase.horario.ExcluirHorario;
import com.fiap.substitutiva.domain.model.Horario;
import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import com.fiap.substitutiva.infra.persistence.horario.HorarioRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class HorarioJPAAdapter implements
        BuscarHorarioPorDia,
        BuscarHorariosPorIdEstabelecimento,
        CadastrarHorario,
        ExcluirHorario {

    private final HorarioRepository repository;
    private final HorarioMapper mapper;

    @Override
    public Horario buscarHorarioPorDia(Long idEstabelecimento, DiasDaSemanaEnum dia) {
        return repository.findByIdEstabelecimentoAndDiaDaSemana(idEstabelecimento, dia)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Horario> buscarPorIdEstabelecimento(Long idEstabelecimento) {
        return repository.findByidEstabelecimento(idEstabelecimento)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Horario cadastrarHorario(Horario horario) {
        return mapper.toDomain(repository.save(mapper.toEntity(horario)));
    }

    @Override
    public void excluirHorario(Long id) {
        repository.deleteById(id);
    }
}
