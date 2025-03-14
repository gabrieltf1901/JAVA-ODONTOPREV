package com.odontoprev.odontoprev.controller;

import com.odontoprev.odontoprev.model.Consulta;
import com.odontoprev.odontoprev.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Lista todas as consultas
    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.listarTodos());
        return "consultas"; // template: consultas.html
    }

    // Exibe formulário para criar uma nova consulta
    @GetMapping("/novo")
    public String novaConsultaForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "consulta_form"; // template: consulta_form.html
    }

    // Salva uma nova consulta ou atualiza uma existente
    @PostMapping("/salvar")
    public String salvarConsulta(@ModelAttribute("consulta") Consulta consulta) {
        consultaService.salvar(consulta);
        return "redirect:/consultas";
    }

    // Exibe formulário para editar uma consulta
    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable("id") Long id, Model model) {
        model.addAttribute("consulta", consultaService.buscarPorId(id).orElse(null));
        return "consulta_form";
    }

    // Remove uma consulta
    @GetMapping("/deletar/{id}")
    public String deletarConsulta(@PathVariable("id") Long id) {
        consultaService.remover(id);
        return "redirect:/consultas";
    }
}

