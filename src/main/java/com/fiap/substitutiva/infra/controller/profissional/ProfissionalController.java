package com.fiap.substitutiva.infra.controller.profissional;

import com.fiap.substitutiva.application.usecase.profissional.impl.AdmitirProfissionalImpl;
import com.fiap.substitutiva.application.usecase.profissional.impl.BuscarProfissionalPorIdImpl;
import com.fiap.substitutiva.application.usecase.profissional.impl.DemitirProfissionalImpl;
import com.fiap.substitutiva.application.usecase.profissional.impl.RegistrarProfissionalImpl;
import com.fiap.substitutiva.domain.model.Profissional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissionais")
@AllArgsConstructor
public class ProfissionalController {

    private final AdmitirProfissionalImpl admitirProfissional;
    private final BuscarProfissionalPorIdImpl buscarProfissionalPorId;
    private final DemitirProfissionalImpl demitirProfissional;
    private final RegistrarProfissionalImpl registrarProfissional;

    @PutMapping("/admitir")
    public ProfissionalDTO admitir(@RequestParam Long idProfissional, @RequestParam Long idEstabelecimento) {
        return new ProfissionalDTO(
                admitirProfissional.admitirProfissional(idProfissional, idEstabelecimento)
        );
    }

    @GetMapping("/{id}")
    public ProfissionalDTO buscarPorId(@PathVariable Long id) {
        return new ProfissionalDTO(
                buscarProfissionalPorId.buscarPorIdProfissional(id)
        );
    }

    @PutMapping("/demitir")
    public ProfissionalDTO demitir(@RequestParam Long idProfissional) {
        return new ProfissionalDTO(
                demitirProfissional.demitir(idProfissional)
        );
    }

    @PostMapping
    public ProfissionalDTO registrar(@RequestBody ProfissionalDTO profissionalDTO) {
        return new ProfissionalDTO(
                registrarProfissional.registrarProfissional(
                        new Profissional(
                                profissionalDTO.id(),
                                profissionalDTO.nome(),
                                profissionalDTO.email(),
                                profissionalDTO.especialidade(),
                                profissionalDTO.tarifaPorHora(),
                                profissionalDTO.idEstabelecimento()
                        )
                )
        );
    }
}
