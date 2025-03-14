package com.odontoprev.odontoprev.controller;

import com.odontoprev.odontoprev.model.Profissional;
import com.odontoprev.odontoprev.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public String listarProfissionais(Model model) {
        model.addAttribute("profissionais", profissionalService.listarTodos());
        return "profissionais"; // template: profissionais.html
    }

    @GetMapping("/novo")
    public String novoProfissionalForm(Model model) {
        model.addAttribute("profissional", new Profissional());
        return "profissional_form"; // template: profissional_form.html
    }

    @PostMapping("/salvar")
    public String salvarProfissional(@ModelAttribute("profissional") Profissional profissional) {
        profissionalService.salvar(profissional);
        return "redirect:/profissionais";
    }

    @GetMapping("/editar/{id}")
    public String editarProfissional(@PathVariable("id") Long id, Model model) {
        model.addAttribute("profissional", profissionalService.buscarPorId(id).orElse(null));
        return "profissional_form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProfissional(@PathVariable("id") Long id) {
        profissionalService.remover(id);
        return "redirect:/profissionais";
    }
}

