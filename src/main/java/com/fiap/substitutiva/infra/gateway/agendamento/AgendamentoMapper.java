package com.fiap.substitutiva.infra.gateway.agendamento;

import com.fiap.substitutiva.domain.model.Agendamento;
import com.fiap.substitutiva.infra.persistence.agendamento.AgendamentoEntity;

public class AgendamentoMapper {

    public Agendamento toDomain(AgendamentoEntity in) {
        return new Agendamento(
        in.getId(),
        in.getIdProfissional(),
        in.getIdEstabelecimento(),
        in.getIdCliente(),
        in.getIdServico(),
        in.getStatus(),
        in.getData(),
        in.getHoraInicio(),
        in.getHoraTermino()
        );
    }

    public AgendamentoEntity toEntity(Agendamento in) {
        return new AgendamentoEntity(
                in.getId(),
                in.getIdProfissional(),
                in.getIdEstabelecimento(),
                in.getIdCliente(),
                in.getIdServico(),
                in.getStatus(),
                in.getData(),
                in.getHoraInicio(),
                in.getHoraTermino()
        );
    }
}
