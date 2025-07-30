package com.fiap.substitutiva.infra.persistence.horario;

import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
    Optional<HorarioEntity> findByIdEstabelecimentoAndDiaDaSemana(Long idEstabelecimento, DiasDaSemanaEnum diaDaSemana);
    List<HorarioEntity> findByidEstabelecimento(Long idEstabelecimento);
}
