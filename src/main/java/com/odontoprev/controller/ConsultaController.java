package com.odontoprev.controller;

import com.odontoprev.dto.ConsultaDTO;
import com.odontoprev.service.ConsultaService;
import com.odontoprev.service.UsuarioService;
import com.odontoprev.service.ProfissionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final UsuarioService usuarioService;
    private final ProfissionalService profissionalService;

    public ConsultaController(ConsultaService consultaService,
                              UsuarioService usuarioService,
                              ProfissionalService profissionalService) {
        this.consultaService = consultaService;
        this.usuarioService = usuarioService;
        this.profissionalService = profissionalService;
    }

    @GetMapping({"", "/list"})
    public String listarConsultas(Model model) {
        List<ConsultaDTO> todas = consultaService.buscarTodas();
        model.addAttribute("consultas", todas);
        return "consultas/list";
    }

    @GetMapping("/nova")
    public String createForm(Model model) {
        model.addAttribute("consulta", new ConsultaDTO());
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("profissionais", profissionalService.findAll());
        return "consultas/form";
    }

    @PostMapping
    public String schedule(@ModelAttribute("consulta") ConsultaDTO dto) {
        consultaService.schedule(dto);
        return "redirect:/consultas";
    }

    @GetMapping("/{id}/editar")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("consulta", consultaService.findById(id));
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("profissionais", profissionalService.findAll());
        return "consultas/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("consulta") ConsultaDTO dto) {
        consultaService.update(id, dto);
        return "redirect:/consultas";
    }

    @GetMapping("/{id}/cancelar")
    public String cancel(@PathVariable Long id) {
        consultaService.cancel(id);
        return "redirect:/consultas";
    }

    @GetMapping("/{id}/excluir")
    public String delete(@PathVariable Long id) {
        consultaService.delete(id);
        return "redirect:/consultas";
    }
}
