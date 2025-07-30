package com.fiap.substitutiva.infra.config.avaliacao;

import com.fiap.substitutiva.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.fiap.substitutiva.application.usecase.avaliacao.*;
import com.fiap.substitutiva.application.usecase.avaliacao.impl.*;
import com.fiap.substitutiva.application.usecase.cliente.BuscarClientePorId;
import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.profissional.BuscarProfissionalPorId;
import com.fiap.substitutiva.infra.gateway.avaliacao.AvaliacaoJPAAdapter;
import com.fiap.substitutiva.infra.gateway.avaliacao.AvaliacaoMapper;
import com.fiap.substitutiva.infra.persistence.avaliacao.AvaliacaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoConfig {

    @Bean
    AvaliarEstabelecimentoImpl avaliarEstabelecimento(AvaliarEstabelecimento avaliarEstabelecimento,
                                                      BuscarClientePorId buscarClientePorId,
                                                      BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                      BuscarAgendamentosPorCliente buscarAgendamentosPorCliente) {
        return new AvaliarEstabelecimentoImpl(avaliarEstabelecimento,
                buscarClientePorId,
                buscarEstabelecimentoPorId,
                buscarAgendamentosPorCliente);
    }

    @Bean
    AvaliarProfissionalImpl avaliarProfissional(AvaliarProfissional avaliarProfissional,
                                                BuscarClientePorId buscarClientePorId,
                                                BuscarProfissionalPorId buscarProfissionalPorId,
                                                BuscarAgendamentosPorCliente buscarAgendamentosPorCliente) {
        return new AvaliarProfissionalImpl(avaliarProfissional,
                buscarClientePorId,
                buscarProfissionalPorId,
                buscarAgendamentosPorCliente);
    }

    @Bean
    BuscarAvaliacoesPorIdClienteImpl buscarAvaliacoesPorIdCliente(BuscarAvaliacoesPorIdCliente buscarAvaliacoesPorIdCliente) {
        return new BuscarAvaliacoesPorIdClienteImpl(buscarAvaliacoesPorIdCliente);
    }

 /*   @Bean
    BuscarAvaliacoesPorIdEstabalecimentoImpl buscarAvaliacoesPorIdEstabalecimento(BuscarAvaliacoesPorIdEstabelecimento buscarAvaliacoesPorIdEstabelecimento) {
        return new BuscarAvaliacoesPorIdEstabalecimentoImpl(buscarAvaliacoesPorIdEstabelecimento);
    }*/

    @Bean
    EditarAvaliacaoImpl editarAvaliacao(EditarAvaliacao editarAvaliacao,
                                        BuscarAvaliacaoPorId buscarAvaliacaoPorId) {
        return new EditarAvaliacaoImpl(editarAvaliacao, buscarAvaliacaoPorId);
    }

    @Bean
    ExcluirAvaliacaoImpl excluirAvaliacao(ExcluirAvaliacao excluirAvaliacao) {
        return new ExcluirAvaliacaoImpl(excluirAvaliacao);
    }

    @Bean
    AvaliacaoJPAAdapter avaliacaoJPAAdapter(AvaliacaoRepository repository, AvaliacaoMapper mapper) {
        return new AvaliacaoJPAAdapter(repository, mapper);
    }

    @Bean
    AvaliacaoMapper avaliacaoMapper() {
        return new AvaliacaoMapper();
    }
}