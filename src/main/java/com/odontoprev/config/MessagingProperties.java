package com.odontoprev.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component("messaging")
@ConfigurationProperties(prefix = "messaging")
@Data
public class MessagingProperties {

    private String exchange;

    private String consultaAgendadaQueue;

    private String consultaCanceladaQueue;

    public String getExchangeConsultaAgendada() {
        return exchange;
    }

    public String getRoutingKeyConsultaAgendada() {
        return consultaAgendadaQueue;
    }

    public String getExchangeConsultaCancelada() {
        return exchange;
    }

    public String getRoutingKeyConsultaCancelada() {
        return consultaCanceladaQueue;
    }
}
