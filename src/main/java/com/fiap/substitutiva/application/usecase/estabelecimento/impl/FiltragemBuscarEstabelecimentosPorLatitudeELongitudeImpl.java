package com.fiap.substitutiva.application.usecase.estabelecimento.impl;

import com.fiap.substitutiva.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.fiap.substitutiva.application.usecase.endereco.FiltragemBuscarEstabelecimentosPorLatitudeELongitude;
import com.fiap.substitutiva.domain.model.Estabelecimento;

import java.util.List;

public class FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl {

    private final FiltragemBuscarEstabelecimentosPorLatitudeELongitude filtragemBuscarEstabelecimentosPorLatitudeELongitude;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl(FiltragemBuscarEstabelecimentosPorLatitudeELongitude filtragemBuscarEstabelecimentosPorLatitudeELongitude, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.filtragemBuscarEstabelecimentosPorLatitudeELongitude = filtragemBuscarEstabelecimentosPorLatitudeELongitude;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }

    public List<Estabelecimento> buscarEstabelecimentoPorLatitudeELongitude(double latitude, double longitude, int metros) {

        double metrosPorGrauLat = 111_320.0;
        double deltaLat = metros / metrosPorGrauLat;

        double metrosPorGrauLng = 111_320.0 * Math.cos(Math.toRadians(latitude));
        double deltaLng = metros / metrosPorGrauLng;

        double latMin = latitude - deltaLat;
        double latMax = latitude + deltaLat;
        double lngMin = longitude - deltaLng;
        double lngMax = longitude + deltaLng;

        return filtragemBuscarEstabelecimentosPorLatitudeELongitude
                .buscarPorLatitudeELongitude(latMin, lngMin, latMax, lngMax)
                .stream()
                .map(buscarEstabelecimentoPorId::buscarEstabelecimentoPorId)
                .toList();
    }

}