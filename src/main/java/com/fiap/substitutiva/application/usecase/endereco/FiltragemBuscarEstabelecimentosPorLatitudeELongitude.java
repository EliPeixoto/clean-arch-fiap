package com.fiap.substitutiva.application.usecase.endereco;

import java.util.List;

public interface FiltragemBuscarEstabelecimentosPorLatitudeELongitude {
    List<Long> buscarPorLatitudeELongitude(
            double minLatitude,
            double minLongitude,
            double maxLatitude,
            double maxLongitude);
}
