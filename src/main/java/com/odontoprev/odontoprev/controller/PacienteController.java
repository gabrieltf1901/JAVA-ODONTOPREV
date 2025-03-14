package com.odontoprev.odontoprev.controller;

import com.odontoprev.odontoprev.model.Paciente;
import com.odontoprev.odontoprev.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Lista todos os pacientes
    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "pacientes"; // template: pacientes.html
    }

    // Exibe formulário para criar um novo paciente
    @GetMapping("/novo")
    public String novoPacienteForm(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente_form"; // template: paciente_form.html
    }

    // Salva um novo paciente ou atualiza um existente
    @PostMapping("/salvar")
    public String salvarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.salvar(paciente);
        return "redirect:/pacientes";
    }

    // Exibe formulário para editar um paciente
    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable("id") Long id, Model model) {
        model.addAttribute("paciente", pacienteService.buscarPorId(id).orElse(null));
        return "paciente_form";
    }

    // Remove um paciente
    @GetMapping("/deletar/{id}")
    public String deletarPaciente(@PathVariable("id") Long id) {
        pacienteService.remover(id);
        return "redirect:/pacientes";
    }
}
