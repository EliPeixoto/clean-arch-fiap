package com.fiap.substitutiva.infra.config.endereco;

import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorId;
import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.endereco.EditarEndereco;
import com.fiap.substitutiva.application.usecase.endereco.RegistrarEndereco;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.infra.gateway.endereco.EnderecoMapper;
import com.fiap.substitutiva.infra.persistence.endereco.EnderecoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class EnderecoConfigTest {

    private final EnderecoConfig config = new EnderecoConfig();

    @Test
    void deveInstanciarBuscarEnderecoPorIdEstabelecimentoImpl() {
        var impl = config.buscarPorEnderecoIdEstabelecimento(mock(BuscarEnderecoPorIdEstabelecimento.class));
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarBuscarEnderecoPorIdImpl() {
        var impl = config.buscarEnderecoPorId(mock(BuscarEnderecoPorId.class));
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEditarEnderecoImpl() {
        var impl = config.editarEndereco(
                mock(EditarEndereco.class),
                mock(BuscarEnderecoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarRegistrarEnderecoImpl() {
        var impl = config.registrarEndereco(
                mock(BuscarEstabelecimentoPorId.class),
                mock(RegistrarEndereco.class),
                mock(BuscarEnderecoPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEnderecoJPAAdapter() {
        var adapter = config.enderecoJPAAdapter(
                mock(EnderecoRepository.class),
                new EnderecoMapper()
        );
        assertNotNull(adapter);
    }

    @Test
    void deveInstanciarEnderecoMapper() {
        var mapper = config.enderecoMapper();
        assertNotNull(mapper);
    }
}
