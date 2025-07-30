package com.fiap.substitutiva.infra.config.foto;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.foto.AdicionarFoto;
import com.fiap.substitutiva.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.foto.ExcluirFoto;
import com.fiap.substitutiva.infra.gateway.foto.FotoMapper;
import com.fiap.substitutiva.infra.persistence.foto.FotoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class FotoConfigTest {

    private final FotoConfig config = new FotoConfig();

    @Test
    void deveInstanciarAdicionarFotoImpl() {
        var impl = config.adicionarFoto(
                mock(AdicionarFoto.class),
                mock(BuscarEstabelecimentoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarBuscarFotosPorIdEstabelecimentoImpl() {
        var impl = config.buscarFotosPorIdEstabelecimento(
                mock(BuscarFotosPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarExcluirFotoImpl() {
        var impl = config.excluirFoto(
                mock(ExcluirFoto.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarFotoJPAAdapter() {
        var impl = config.fotoJPAAdapter(
                mock(FotoRepository.class),
                new FotoMapper()
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarFotoMapper() {
        assertNotNull(config.fotoMapper());
    }
}
