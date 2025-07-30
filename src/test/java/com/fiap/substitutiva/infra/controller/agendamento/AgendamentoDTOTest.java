package com.fiap.substitutiva.infra.controller.agendamento;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

import com.fiap.substitutiva.domain.model.Agendamento;
import com.fiap.substitutiva.domain.model.constant.StatusEnum;

public class AgendamentoDTOTest {

    @Test
    void deveConstruirDTOCorretamenteAPartirDeAgendamento() {
        LocalDate data = LocalDate.of(2025, 1, 1);
        LocalTime inicio = LocalTime.of(10, 0);
        LocalTime fim = LocalTime.of(11, 0);

        Agendamento agendamento = new Agendamento(
                1L,
                2L,
                3L,
                4L,
                5L,
                StatusEnum.AGENDADO,
                data,
                inicio,
                fim
        );

        AgendamentoDTO dto = new AgendamentoDTO(agendamento);

        assertEquals(1L, dto.id());
        assertEquals(2L, dto.idProfissional());
        assertEquals(3L, dto.idEstabelecimento());
        assertEquals(4L, dto.idCliente());
        assertEquals(5L, dto.idServico());
        assertEquals(StatusEnum.AGENDADO, dto.status());
        assertEquals(data, dto.data());
        assertEquals(inicio, dto.horaInicio());
        assertEquals(fim, dto.horaTermino());
    }
}
