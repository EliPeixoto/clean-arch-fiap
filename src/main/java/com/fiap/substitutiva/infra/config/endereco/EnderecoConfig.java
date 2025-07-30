package com.fiap.substitutiva.infra.config.endereco;

import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorId;
import com.fiap.substitutiva.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.endereco.EditarEndereco;
import com.fiap.substitutiva.application.usecase.endereco.RegistrarEndereco;
import com.fiap.substitutiva.application.usecase.endereco.impl.BuscarEnderecoPorIdImpl;
import com.fiap.substitutiva.application.usecase.endereco.impl.BuscarEnderecoPorIdEstabelecimentoImpl;
import com.fiap.substitutiva.application.usecase.endereco.impl.EditarEnderecoImpl;
import com.fiap.substitutiva.application.usecase.endereco.impl.RegistrarEnderecoImpl;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.infra.gateway.endereco.EnderecoJPAAdapter;
import com.fiap.substitutiva.infra.gateway.endereco.EnderecoMapper;
import com.fiap.substitutiva.infra.persistence.endereco.EnderecoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoConfig {

    @Bean
    BuscarEnderecoPorIdEstabelecimentoImpl buscarPorEnderecoIdEstabelecimento(BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        return new BuscarEnderecoPorIdEstabelecimentoImpl(buscarEnderecoPorIdEstabelecimento);
    }

    @Bean
    BuscarEnderecoPorIdImpl buscarEnderecoPorId(BuscarEnderecoPorId buscarEnderecoPorId) {
        return new BuscarEnderecoPorIdImpl(buscarEnderecoPorId);
    }

    @Bean
    EditarEnderecoImpl editarEndereco(EditarEndereco editarEndereco, BuscarEnderecoPorId buscarEnderecoPorId) {
        return new EditarEnderecoImpl(editarEndereco, buscarEnderecoPorId);
    }

    @Bean
    RegistrarEnderecoImpl registrarEndereco(BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                            RegistrarEndereco registrarEndereco,
                                            BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        return new RegistrarEnderecoImpl(buscarEstabelecimentoPorId, registrarEndereco, buscarEnderecoPorIdEstabelecimento);
    }

    @Bean
    EnderecoJPAAdapter enderecoJPAAdapter(EnderecoRepository repository, EnderecoMapper mapper) {
        return new EnderecoJPAAdapter(repository, mapper);
    }

    @Bean
    EnderecoMapper enderecoMapper() {
        return new EnderecoMapper();
    }
}
