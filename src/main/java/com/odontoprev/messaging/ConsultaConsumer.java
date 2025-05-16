package com.odontoprev.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsultaConsumer {

    @RabbitListener(queues = "#{messaging.consultaAgendadaQueue}")
    public void receiveAgendada(Object payload) {
    }

    @RabbitListener(queues = "#{messaging.consultaCanceladaQueue}")
    public void receiveCancelada(Object payload) {
    }
}
