package com.fiap.substitutiva.infra.controller.horario;

import com.fiap.substitutiva.application.usecase.horario.impl.BuscarHorariosPorIdEstabelecimentoImpl;
import com.fiap.substitutiva.application.usecase.horario.impl.CadastrarHorarioImpl;
import com.fiap.substitutiva.application.usecase.horario.impl.ExcluirHorarioImpl;
import com.fiap.substitutiva.domain.model.Horario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@AllArgsConstructor
public class HorarioController {

    private final BuscarHorariosPorIdEstabelecimentoImpl buscarHorariosPorIdEstabelecimento;
    private final CadastrarHorarioImpl cadastrarHorario;
    private final ExcluirHorarioImpl excluirHorario;

    @GetMapping("/estabelecimentos/{id}")
    public List<HorarioDTO> buscarPorEstabelecimento(@PathVariable Long id) {
        return buscarHorariosPorIdEstabelecimento.buscarHorariosPorIdEstabelecimento(id)
                .stream()
                .map(HorarioDTO::new)
                .toList();
    }

    @PostMapping
    public HorarioDTO cadastrar(@RequestBody HorarioDTO horarioDTO) {
        return new HorarioDTO(
                cadastrarHorario.cadastraHorario(
                        new Horario(
                                horarioDTO.id(),
                                horarioDTO.diaDaSemana(),
                                horarioDTO.inicio(),
                                horarioDTO.fim(),
                                horarioDTO.idEstabelecimento()
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public void deletarHorario(@PathVariable Long id){
        excluirHorario.excluirHorario(id);
    }
}
