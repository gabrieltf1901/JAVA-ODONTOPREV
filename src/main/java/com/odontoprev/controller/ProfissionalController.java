package com.odontoprev.controller;

import com.odontoprev.dto.ProfissionalDTO;
import com.odontoprev.service.ProfissionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping({"", "/list"})
    public String list(Model model) {
        model.addAttribute("profissionais", profissionalService.findAll());
        return "profissional/list";
    }

    @GetMapping("/novo")
    public String createForm(Model model) {
        model.addAttribute("profissional", new ProfissionalDTO());
        return "profissional/form";
    }

    @PostMapping
    public String create(@ModelAttribute("profissional") ProfissionalDTO dto) {
        profissionalService.create(dto);
        return "redirect:/profissionais";
    }

    @GetMapping("/{id}/editar")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("profissional", profissionalService.findById(id));
        return "profissional/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("profissional") ProfissionalDTO dto) {
        profissionalService.update(id, dto);
        return "redirect:/profissionais";
    }

    @GetMapping("/{id}/excluir")
    public String delete(@PathVariable Long id) {
        profissionalService.delete(id);
        return "redirect:/profissionais";
    }
}
