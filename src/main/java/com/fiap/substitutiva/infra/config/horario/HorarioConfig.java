package com.fiap.substitutiva.infra.config.horario;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.horario.CadastrarHorario;
import com.fiap.substitutiva.application.usecase.horario.ExcluirHorario;
import com.fiap.substitutiva.application.usecase.horario.impl.BuscarHorariosPorIdEstabelecimentoImpl;
import com.fiap.substitutiva.application.usecase.horario.impl.CadastrarHorarioImpl;
import com.fiap.substitutiva.application.usecase.horario.impl.ExcluirHorarioImpl;
import com.fiap.substitutiva.infra.gateway.horario.HorarioJPAAdapter;
import com.fiap.substitutiva.infra.gateway.horario.HorarioMapper;
import com.fiap.substitutiva.infra.persistence.horario.HorarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HorarioConfig {

    @Bean
    BuscarHorariosPorIdEstabelecimentoImpl buscarHorariosPorIdEstabelecimento(BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento){
        return new BuscarHorariosPorIdEstabelecimentoImpl(buscarHorariosPorIdEstabelecimento);
    }

    @Bean
    CadastrarHorarioImpl cadastrarHorario(CadastrarHorario cadastrarHorario,
                                                  BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                  BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento){
        return new CadastrarHorarioImpl(cadastrarHorario, buscarEstabelecimentoPorId, buscarHorariosPorIdEstabelecimento);
    }

    @Bean
    ExcluirHorarioImpl excluirHorario(ExcluirHorario excluirHorario){
        return new ExcluirHorarioImpl(excluirHorario);
    }

    @Bean
    HorarioJPAAdapter horarioJPAAdapter(HorarioRepository repository, HorarioMapper mapper){
        return new HorarioJPAAdapter(repository, mapper);
    }

    @Bean
    HorarioMapper horarioMapper(){
        return new HorarioMapper();
    }
}
