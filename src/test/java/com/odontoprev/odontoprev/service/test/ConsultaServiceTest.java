package com.odontoprev.odontoprev.service.test;

import com.odontoprev.odontoprev.model.Consulta;

import com.odontoprev.odontoprev.service.ConsultaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConsultaServiceTest {

    @Autowired
    private ConsultaService consultaService;

    /**
     * Método auxiliar que simula a análise preditiva para consultas.
     * Neste exemplo, se o valor da consulta for maior que 300, o risco é considerado "Alto",
     * caso contrário, "Baixo".
     */
    private String calcularRiscoConsulta(Consulta consulta) {
        if (consulta.getValorConsulta() != null && consulta.getValorConsulta() > 300) {
            return "Alto";
        }
        return "Baixo";
    }

    @Test
    public void testCriacaoConsultaEAnalisePreditiva() {
        Consulta consulta = new Consulta();
        consulta.setDataHoraConsulta(new Date());
        consulta.setTipoProcedimento("Exame de rotina");
        consulta.setValorConsulta(350.0);
        consulta.setStatus("Agendada");
        consulta.setProfissionalOpId(1L);

        // Salva a consulta e verifica se o ID foi atribuído
        Consulta salvo = consultaService.salvar(consulta);
        assertNotNull(salvo.getId(), "A consulta deve ter um ID após ser salva");

        // Realiza a análise preditiva (simulada) e valida o resultado
        String riscoCalculado = calcularRiscoConsulta(salvo);
        assertEquals("Alto", riscoCalculado, "O risco deve ser calculado como Alto para valorConsulta > 300");
    }
}
