package com.fiap.substitutiva.infra.config.profissional;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.profissional.AdmitirProfissional;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.profissional.EditarProfissional;
import com.fiap.substitutiva.application.usecase.profissional.RegistrarProfissional;
import com.fiap.substitutiva.infra.gateway.profissional.ProfissionalMapper;
import com.fiap.substitutiva.infra.persistence.profissional.ProfissionalRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ProfissionalConfigTest {

    private final ProfissionalConfig config = new ProfissionalConfig();

    @Test
    void deveInstanciarAdmitirProfissionalImpl() {
        var bean = config.admitirProfissional(
                mock(AdmitirProfissional.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarProfissionalPorId.class)
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarBuscarProfissionalPorIdImpl() {
        var bean = config.buscarProfissionalPorId(mock(BuscarProfissionalPorId.class));
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarDemitirProfissionalImpl() {
        var bean = config.demitirProfissional(
                mock(BuscarProfissionalPorId.class),
                mock(EditarProfissional.class)
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarRegistrarProfissionalImpl() {
        var bean = config.registrarProfissional(mock(RegistrarProfissional.class));
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarProfissionalJPAAdapter() {
        var bean = config.profissionalJPAAdapter(
                mock(ProfissionalRepository.class),
                new ProfissionalMapper()
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarProfissionalMapper() {
        assertNotNull(config.profissionalMapper());
    }
}
