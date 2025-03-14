package com.odontoprev.odontoprev.controller;

import com.odontoprev.odontoprev.model.Procedimento;
import com.odontoprev.odontoprev.service.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping
    public String listarProcedimentos(Model model) {
        model.addAttribute("procedimentos", procedimentoService.listarTodos());
        return "procedimentos"; // template: procedimentos.html
    }

    @GetMapping("/novo")
    public String novoProcedimentoForm(Model model) {
        model.addAttribute("procedimento", new Procedimento());
        return "procedimento_form"; // template: procedimento_form.html
    }

    @PostMapping("/salvar")
    public String salvarProcedimento(@ModelAttribute("procedimento") Procedimento procedimento) {
        procedimentoService.salvar(procedimento);
        return "redirect:/procedimentos";
    }

    @GetMapping("/editar/{id}")
    public String editarProcedimento(@PathVariable("id") Long id, Model model) {
        model.addAttribute("procedimento", procedimentoService.buscarPorId(id).orElse(null));
        return "procedimento_form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProcedimento(@PathVariable("id") Long id) {
        procedimentoService.remover(id);
        return "redirect:/procedimentos";
    }
}

