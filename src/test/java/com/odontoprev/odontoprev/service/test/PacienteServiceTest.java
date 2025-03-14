package com.odontoprev.odontoprev.service.test;

import com.odontoprev.odontoprev.model.Paciente;
import com.odontoprev.odontoprev.service.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    /**
     * Método auxiliar que simula a análise preditiva.
     * Neste exemplo, se o campo 'historicoMedico' contém a palavra "sinistro",
     * o risco é considerado "Alto", caso contrário, "Baixo".
     */
    private String calcularRisco(Paciente paciente) {
        if(paciente.getHistoricoMedico() != null &&
                paciente.getHistoricoMedico().toLowerCase().contains("sinistro")) {
            return "Alto";
        }
        return "Baixo";
    }

    @Test
    public void testCriacaoPacienteEAnalisePreditiva() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNomeCompleto("Paciente de Risco");
        paciente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980"));
        paciente.setContato("99999-8888");
        paciente.setPlanoDeSaude("Plano A");
        paciente.setHistoricoMedico("Paciente com histórico de sinistro e cancelamento");

        // Salva o paciente e verifica se o ID foi atribuído
        Paciente salvo = pacienteService.salvar(paciente);
        assertNotNull(salvo.getId(), "O paciente deve ter um ID após ser salvo");

        // Realiza a análise preditiva (simulada) e valida o resultado
        String riscoCalculado = calcularRisco(salvo);
        assertEquals("Alto", riscoCalculado, "O risco deve ser calculado como Alto para histórico com 'sinistro'");
    }
}
