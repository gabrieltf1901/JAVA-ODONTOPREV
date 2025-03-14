# Challenge Odontoprev

## LINK VÍDEO DE APRESENTAÇÃO ---> https://youtu.be/oJyi9yUKL64

## Objetivo
O projeto Challenge **Odontoprev** tem como objetivo a redução de sinistros por meio de análise preditiva de atendimentos odontológicos. A aplicação web permite o gerenciamento de dados (Pacientes, Consultas, Faturamento, Procedimentos e Profissionais) utilizando o padrão MVC, facilitando a manutenção e a evolução do sistema.

## Integrantes
- **Gabriel Torres Fernandes** - RM553635

## Arquitetura da Solução

A aplicação foi desenvolvida com uma arquitetura em camadas, seguindo o padrão MVC:

- **Model:** Classes de entidade (Paciente, Consulta, Faturamento, Procedimento, Profissional) mapeadas com JPA.
- **Repository:** Interfaces que estendem `JpaRepository` para acesso e manipulação dos dados.
- **Service:** Camada de lógica de negócio, que orquestra as operações dos repositórios e encapsula as regras de negócio.
- **Controller:** Responsável por gerenciar as requisições HTTP e direcionar para os templates Thymeleaf.
- **View:** Templates HTML utilizando Thymeleaf e Bootstrap 5 para uma interface moderna, responsiva e agradável.

## Tecnologias Utilizadas
- **Linguagem:** Java 21
- **Frameworks:** Spring Boot, Spring Data JPA, Thymeleaf
- **Banco de Dados:** Oracle
- **Driver JDBC:** ojdbc11 (configurado via Maven ou instalado manualmente)
- **Build:** Maven
- **Frontend:** Bootstrap 5 (via CDN)

## Configuração do Banco de Dados
- **URL de Conexão:** `jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL`
- **Usuário:** rm553635
- **Senha:** 190101

## Desenvolvimento
### CRUDs Implementados
- Paciente: Cadastro, listagem, edição e exclusão.
- Consulta: Cadastro, listagem, edição e exclusão.

Os exemplos de implementação seguem a estrutura padrão do Spring Boot, onde cada camada (Controller, Service, Repository e Model) é responsável por uma parte do fluxo de dados.

## Exemplo de Testes

Foram implementados testes. Seguem alguns exemplos:

- **Exemplo de teste para Paciente**
```
import com.odontoprev.model.Paciente;
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
```

- **Exemplo de teste para Consulta**
```
import com.odontoprev.model.Consulta;
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
```

## Execução da Aplicação
### Compilação e Execução

1. Configurar o banco de dados no arquivo "application.properties"
2. Compilar o projeto.
3. Executar a aplicação.
4. Acessar a aplicação:
- Por padrão, a aplicação roda na porta 8080. Acesse via http://localhost:8080.


## Dificuldades Encontradas
- Integração com Oracle:

Configuração do driver e ajuste do dialeto do Hibernate devido à remoção dos dialetos específicos (Oracle10gDialect/Oracle12cDialect) nas versões mais recentes do Hibernate.

- Ajustes de Ambiente:

Instalação manual do driver Oracle.

- Integração entre Camadas:

Garantir a coesão e a integração correta entre as camadas Model, Repository, Service e Controller exigiu testes e ajustes contínuos.

## Próximos Passos
- Expansão dos CRUDs:

Implementar operações completas para as demais entidades (Faturamento, Procedimento, Profissional).

- Integração de Análise Preditiva:

Adicionar módulos que utilizem técnicas de Machine Learning para prever e reduzir sinistros.

- Aprimoramento da Interface:

Melhorar o design e a experiência do usuário, adicionando novos recursos e testes de usabilidade.

- Testes Automatizados:

Ampliar a cobertura de testes unitários e de integração para aumentar a confiabilidade do sistema.


## Conclusão
O projeto Odontoprev apresenta uma solução robusta e escalável para a gestão de atendimentos odontológicos com foco na redução de sinistros. Utilizando tecnologias modernas e uma arquitetura bem estruturada, a aplicação demonstra a viabilidade de integrar dados e análises preditivas para melhorar a qualidade dos serviços.





