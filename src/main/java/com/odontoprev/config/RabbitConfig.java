package com.odontoprev.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MessagingProperties.class)
public class RabbitConfig {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory cf,
            Jackson2JsonMessageConverter converter) {
        RabbitTemplate tpl = new RabbitTemplate(cf);
        tpl.setMessageConverter(converter);
        return tpl;
    }

    private final MessagingProperties props;

    public RabbitConfig(@Qualifier("messaging-com.odontoprev.config.MessagingProperties") MessagingProperties props) {
        this.props = props;
    }

    @Bean
    public Queue consultaAgendadaQueue() {
        return new Queue(props.getConsultaAgendadaQueue(), true);
    }

    @Bean
    public Queue consultaCanceladaQueue() {
        return new Queue(props.getConsultaCanceladaQueue(), true);
    }

    @Bean
    public Exchange odontoprevExchange() {
        return ExchangeBuilder
                .directExchange(props.getExchange())
                .durable(true)
                .build();
    }

    @Bean
    public Binding bindingConsultaAgendada(Queue consultaAgendadaQueue, Exchange odontoprevExchange) {
        return BindingBuilder
                .bind(consultaAgendadaQueue)
                .to(odontoprevExchange)
                .with(props.getConsultaAgendadaQueue())
                .noargs();
    }

    @Bean
    public Binding bindingConsultaCancelada(Queue consultaCanceladaQueue, Exchange odontoprevExchange) {
        return BindingBuilder
                .bind(consultaCanceladaQueue)
                .to(odontoprevExchange)
                .with(props.getConsultaCanceladaQueue())
                .noargs();
    }
}
