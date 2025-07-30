package com.fiap.substitutiva.infra.persistence.horario;

import com.fiap.substitutiva.domain.model.constant.DiasDaSemanaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DiasDaSemanaEnum diaDaSemana;
    private LocalTime inicio;
    private LocalTime fim;
    private Long idEstabelecimento;
}
