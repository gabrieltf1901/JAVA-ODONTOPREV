package com.odontoprev.odontoprev.controller;

import com.odontoprev.odontoprev.model.Faturamento;
import com.odontoprev.odontoprev.service.FaturamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faturamentos")
public class FaturamentoController {

    @Autowired
    private FaturamentoService faturamentoService;

    @GetMapping
    public String listarFaturamentos(Model model) {
        model.addAttribute("faturamentos", faturamentoService.listarTodos());
        return "faturamentos"; // template: faturamentos.html
    }

    @GetMapping("/novo")
    public String novoFaturamentoForm(Model model) {
        model.addAttribute("faturamento", new Faturamento());
        return "faturamento_form"; // template: faturamento_form.html
    }

    @PostMapping("/salvar")
    public String salvarFaturamento(@ModelAttribute("faturamento") Faturamento faturamento) {
        faturamentoService.salvar(faturamento);
        return "redirect:/faturamentos";
    }

    @GetMapping("/editar/{id}")
    public String editarFaturamento(@PathVariable("id") Long id, Model model) {
        model.addAttribute("faturamento", faturamentoService.buscarPorId(id).orElse(null));
        return "faturamento_form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFaturamento(@PathVariable("id") Long id) {
        faturamentoService.remover(id);
        return "redirect:/faturamentos";
    }
}
