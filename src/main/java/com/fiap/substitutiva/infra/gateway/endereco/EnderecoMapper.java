package com.fiap.substitutiva.infra.gateway.endereco;

import com.fiap.substitutiva.domain.model.Endereco;
import com.fiap.substitutiva.infra.persistence.endereco.EnderecoEntity;
import org.springframework.data.domain.Sort;

public class EnderecoMapper {

    public Endereco toDomain(EnderecoEntity in){
        return new Endereco(
        in.getId(),
        in.getLogradouro(),
        in.getCep(),
        in.getNumero(),
        in.getLatitude(),
        in.getLongitude(),
        in.getIdEstabelecimento()
        );
    }

    public EnderecoEntity toEntity(Endereco in){
        return new EnderecoEntity(
                in.getId(),
                in.getLogradouro(),
                in.getCep(),
                in.getNumero(),
                in.getLatitude(),
                in.getLongitude(),
                in.getIdEstabelecimento()
        );
    }

    public Sort toEntityEmpty(Endereco endereco){
        return null;
    }
}
