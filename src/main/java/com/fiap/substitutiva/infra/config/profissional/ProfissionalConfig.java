package com.fiap.substitutiva.infra.config.profissional;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.profissional.AdmitirProfissional;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.application.usecase.profissional.EditarProfissional;
import com.fiap.substitutiva.application.usecase.profissional.RegistrarProfissional;
import com.fiap.substitutiva.application.usecase.profissional.impl.AdmitirProfissionalImpl;
import com.fiap.substitutiva.application.usecase.profissional.impl.BuscarProfissionalPorIdImpl;
import com.fiap.substitutiva.application.usecase.profissional.impl.DemitirProfissionalImpl;
import com.fiap.substitutiva.application.usecase.profissional.impl.RegistrarProfissionalImpl;
import com.fiap.substitutiva.infra.gateway.profissional.ProfissionalJPAAdapter;
import com.fiap.substitutiva.infra.gateway.profissional.ProfissionalMapper;
import com.fiap.substitutiva.infra.persistence.profissional.ProfissionalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfissionalConfig {

    @Bean
    AdmitirProfissionalImpl admitirProfissional(AdmitirProfissional admitirProfissional,
                                                        BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                        BuscarProfissionalPorId buscarProfissionalPorId){
        return new AdmitirProfissionalImpl(admitirProfissional, buscarEstabelecimentoPorId, buscarProfissionalPorId);
    }

    @Bean
    BuscarProfissionalPorIdImpl buscarProfissionalPorId(BuscarProfissionalPorId buscarProfissionalPorId) {
        return new BuscarProfissionalPorIdImpl(buscarProfissionalPorId);
    }

    @Bean
    DemitirProfissionalImpl demitirProfissional(BuscarProfissionalPorId buscarProfissionalPorId,
                                                        EditarProfissional editarProfissional) {
        return new DemitirProfissionalImpl(buscarProfissionalPorId, editarProfissional);
    }

    @Bean
    RegistrarProfissionalImpl registrarProfissional(RegistrarProfissional registrarProfissional) {
        return new RegistrarProfissionalImpl(registrarProfissional);
    }

    @Bean
    ProfissionalJPAAdapter profissionalJPAAdapter(ProfissionalRepository repository, ProfissionalMapper mapper){
        return new ProfissionalJPAAdapter(repository, mapper);
    }

    @Bean
    ProfissionalMapper profissionalMapper(){
        return new ProfissionalMapper();
    }
}
