package com.fiap.substitutiva.infra.config.servico;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.servico.BuscarPorIdEstabelecimento;
import com.fiap.substitutiva.application.usecase.servico.ExcluirServico;
import com.fiap.substitutiva.application.usecase.servico.FinalizarServico;
import com.fiap.substitutiva.application.usecase.servico.RegistrarServico;
import com.fiap.substitutiva.application.usecase.servico.impl.BuscarPorIdEstabelecimentoImpl;
import com.fiap.substitutiva.application.usecase.servico.impl.ExcluirServicoImpl;
import com.fiap.substitutiva.application.usecase.servico.impl.FinalizarServicoImpl;
import com.fiap.substitutiva.application.usecase.servico.impl.RegistrarServicoImpl;
import com.fiap.substitutiva.domain.gateway.AgendamentoGateway;
import com.fiap.substitutiva.infra.gateway.servico.ServicoJPAAdapter;
import com.fiap.substitutiva.infra.gateway.servico.ServicoMapper;
import com.fiap.substitutiva.infra.persistence.servico.ServicoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoConfig {

    @Bean
    BuscarPorIdEstabelecimentoImpl buscarPorIdEstabelecimento(BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        return new BuscarPorIdEstabelecimentoImpl(buscarPorIdEstabelecimento);
    }

    @Bean
    ExcluirServicoImpl excluirServico(ExcluirServico excluirServico) {
        return new ExcluirServicoImpl(excluirServico);
    }

    @Bean
    RegistrarServicoImpl registrarServico(RegistrarServico registrarServico,
                                                  BuscarEstabelecimentoPorId buscarEstabelecimentoPorId){
        return new RegistrarServicoImpl(registrarServico, buscarEstabelecimentoPorId);
    }

    @Bean
    ServicoJPAAdapter servicoJPAAdapter(ServicoRepository repository, ServicoMapper mapper) {
        return new ServicoJPAAdapter(repository, mapper);
    }

    @Bean
    ServicoMapper servicoMapper(){
        return new ServicoMapper();
    }

    @Bean
    public FinalizarServico finalizarServico(AgendamentoGateway agendamentoGateway) {
        return new FinalizarServicoImpl(agendamentoGateway);
    }

}
