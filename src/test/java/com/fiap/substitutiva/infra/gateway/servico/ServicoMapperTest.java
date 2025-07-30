package com.fiap.substitutiva.infra.gateway.servico;

import com.fiap.substitutiva.domain.model.Servico;
import com.fiap.substitutiva.infra.persistence.servico.ServicoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoMapperTest {

    private final ServicoMapper mapper = new ServicoMapper();

    @Test
    void testToDomain() {
        ServicoEntity entity = new ServicoEntity(
                1L,
                "Corte de Cabelo",
                50,
                100L
        );

        Servico domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getValor(), domain.getValor());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
    }

    @Test
    void testToEntity() {
        Servico domain = new Servico(
                2L,
                "Maquiagem",
                80,
                200L
        );

        ServicoEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getValor(), entity.getValor());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
    }
}
