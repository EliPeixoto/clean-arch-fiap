package com.fiap.substitutiva.infra.gateway.notificacao;

import com.fiap.substitutiva.application.usecase.notificacao.EnviarEmailNotificandoAgendamento;

public class EnvioDeEmailAdapter implements
        EnviarEmailNotificandoAgendamento {

    @Override
    public void enviarEmailNotificandoOAgendamento(String emailCliente, String emailProfissional) {
        //Lógica para realizar o agendamento no Outlook;
    }
}
