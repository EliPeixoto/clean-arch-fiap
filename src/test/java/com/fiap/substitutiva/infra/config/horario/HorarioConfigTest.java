package com.fiap.substitutiva.infra.config.horario;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.horario.CadastrarHorario;
import com.fiap.substitutiva.application.usecase.horario.ExcluirHorario;
import com.fiap.substitutiva.infra.gateway.horario.HorarioMapper;
import com.fiap.substitutiva.infra.persistence.horario.HorarioRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class HorarioConfigTest {

    private final HorarioConfig config = new HorarioConfig();

    @Test
    void deveInstanciarBuscarHorariosPorIdEstabelecimentoImpl() {
        var impl = config.buscarHorariosPorIdEstabelecimento(
                mock(BuscarHorariosPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarCadastrarHorarioImpl() {
        var impl = config.cadastrarHorario(
                mock(CadastrarHorario.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarHorariosPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarExcluirHorarioImpl() {
        var impl = config.excluirHorario(
                mock(ExcluirHorario.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarHorarioJPAAdapter() {
        var impl = config.horarioJPAAdapter(
                mock(HorarioRepository.class),
                new HorarioMapper()
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarHorarioMapper() {
        assertNotNull(config.horarioMapper());
    }
}
