package com.fiap.substitutiva.infra.gateway.horario;

import com.fiap.substitutiva.domain.model.Horario;
import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import com.fiap.substitutiva.infra.persistence.horario.HorarioEntity;
import com.fiap.substitutiva.infra.persistence.horario.HorarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HorarioJPAAdapterTest {

    private HorarioRepository repository;
    private HorarioMapper mapper;
    private HorarioJPAAdapter adapter;

    private Horario horarioDomain;
    private HorarioEntity horarioEntity;

    @BeforeEach
    void setup() {
        repository = mock(HorarioRepository.class);
        mapper = Mockito.mock(HorarioMapper.class);
        adapter = new HorarioJPAAdapter(repository, mapper);

        horarioDomain = new Horario(1L, DiasDaSemanaEnum.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(18, 0), 101L);
        horarioEntity = new HorarioEntity();
    }

    @Test
    void testBuscarHorarioPorDiaExistente() {
        when(repository.findByIdEstabelecimentoAndDiaDaSemana(101L, DiasDaSemanaEnum.WEDNESDAY))
                .thenReturn(Optional.of(horarioEntity));
        when(mapper.toDomain(horarioEntity)).thenReturn(horarioDomain);

        Horario result = adapter.buscarHorarioPorDia(101L, DiasDaSemanaEnum.WEDNESDAY);

        assertNotNull(result);
        assertEquals(horarioDomain, result);
    }

    @Test
    void testBuscarHorarioPorDiaNaoExistente() {
        when(repository.findByIdEstabelecimentoAndDiaDaSemana(101L, DiasDaSemanaEnum.WEDNESDAY))
                .thenReturn(Optional.empty());

        Horario result = adapter.buscarHorarioPorDia(101L, DiasDaSemanaEnum.WEDNESDAY);

        assertNull(result);
    }

    @Test
    void testBuscarPorIdEstabelecimento() {
        when(repository.findByidEstabelecimento(101L)).thenReturn(List.of(horarioEntity));
        when(mapper.toDomain(horarioEntity)).thenReturn(horarioDomain);

        List<Horario> result = adapter.buscarPorIdEstabelecimento(101L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(horarioDomain, result.get(0));
    }

    @Test
    void testCadastrarHorario() {
        when(mapper.toEntity(horarioDomain)).thenReturn(horarioEntity);
        when(repository.save(horarioEntity)).thenReturn(horarioEntity);
        when(mapper.toDomain(horarioEntity)).thenReturn(horarioDomain);

        Horario result = adapter.cadastrarHorario(horarioDomain);

        assertNotNull(result);
        assertEquals(horarioDomain, result);
    }

    @Test
    void testExcluirHorario() {
        adapter.excluirHorario(1L);
        verify(repository).deleteById(1L);
    }
}
