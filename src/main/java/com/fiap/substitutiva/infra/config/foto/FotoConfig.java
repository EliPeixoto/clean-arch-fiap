package com.fiap.substitutiva.infra.config.foto;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.foto.AdicionarFoto;
import com.fiap.substitutiva.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.foto.ExcluirFoto;
import com.fiap.substitutiva.application.usecase.foto.impl.AdicionarFotoImpl;
import com.fiap.substitutiva.application.usecase.foto.impl.BuscarFotosPorIdEstabelecimentoImpl;
import com.fiap.substitutiva.application.usecase.foto.impl.ExcluirFotoImpl;
import com.fiap.substitutiva.infra.gateway.foto.FotoJPAAdapter;
import com.fiap.substitutiva.infra.gateway.foto.FotoMapper;
import com.fiap.substitutiva.infra.persistence.foto.FotoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FotoConfig {

    @Bean
    AdicionarFotoImpl adicionarFoto(AdicionarFoto adicionarFoto,
                                            BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new AdicionarFotoImpl(adicionarFoto, buscarEstabelecimentoPorId);
    }

    @Bean
    BuscarFotosPorIdEstabelecimentoImpl buscarFotosPorIdEstabelecimento(
            BuscarFotosPorIdEstabelecimento buscarFotosPorIdEstabelecimento
    ) {
        return new BuscarFotosPorIdEstabelecimentoImpl(buscarFotosPorIdEstabelecimento);
    }

    @Bean
    ExcluirFotoImpl excluirFoto(ExcluirFoto excluirFoto) {
        return new ExcluirFotoImpl(excluirFoto);
    }

    @Bean
    FotoJPAAdapter fotoJPAAdapter(FotoRepository repository, FotoMapper mapper) {
        return new FotoJPAAdapter(repository, mapper);
    }

    @Bean
    FotoMapper fotoMapper(){
        return new FotoMapper();
    }
}
