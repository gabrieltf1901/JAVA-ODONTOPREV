package com.odontoprev.messaging;

import com.odontoprev.config.MessagingProperties;
import com.odontoprev.model.Consulta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProducer {

    private final RabbitTemplate rabbitTemplate;
    private final MessagingProperties props;

    public ConsultaProducer(RabbitTemplate rabbitTemplate,
                            @Qualifier("messaging") MessagingProperties props) {
        this.rabbitTemplate = rabbitTemplate;
        this.props = props;
    }

    public void sendConsultaAgendada(Consulta consulta) {
        rabbitTemplate.convertAndSend(
                props.getExchangeConsultaAgendada(),
                props.getRoutingKeyConsultaAgendada(),
                consulta
        );
    }

    public void sendConsultaCancelada(Consulta consulta) {
        rabbitTemplate.convertAndSend(
                props.getExchangeConsultaCancelada(),
                props.getRoutingKeyConsultaCancelada(),
                consulta
        );
    }
}
