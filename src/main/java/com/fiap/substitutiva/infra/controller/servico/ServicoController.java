package com.fiap.substitutiva.infra.controller.servico;

import com.fiap.substitutiva.application.usecase.servico.FinalizarServico;
import com.fiap.substitutiva.application.usecase.servico.impl.BuscarPorIdEstabelecimentoImpl;
import com.fiap.substitutiva.application.usecase.servico.impl.ExcluirServicoImpl;
import com.fiap.substitutiva.application.usecase.servico.impl.RegistrarServicoImpl;
import com.fiap.substitutiva.domain.model.Servico;
import com.fiap.substitutiva.infra.controller.agendamento.AgendamentoDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@AllArgsConstructor
public class ServicoController {

    private final BuscarPorIdEstabelecimentoImpl buscarPorIdEstabelecimento;
    private final ExcluirServicoImpl excluirServico;
    private final RegistrarServicoImpl registrarServico;
    private final FinalizarServico finalizarServico;

    @GetMapping("/estabelecimento/{id}")
    public List<ServicoDTO> buscarPorEstabelecimento(@PathVariable Long id) {
        return buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(id)
                .stream()
                .map(ServicoDTO::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void excluirServico(@PathVariable Long id) {
        excluirServico.cancelar(id);
    }

    @PostMapping
    public ServicoDTO registrar(@RequestBody ServicoDTO servicoDTO) {
        return new ServicoDTO(
                registrarServico.registrarServico(
                        new Servico(
                                servicoDTO.id(),
                                servicoDTO.nome(),
                                servicoDTO.valor(),
                                servicoDTO.idEstabelecimento()
                        )
                )
        );
    }

    @PutMapping("/{id}/finalizar")
    public AgendamentoDTO finalizar(@PathVariable Long id) {
        return new AgendamentoDTO(finalizarServico.finalizarServico(id));
    }
}
