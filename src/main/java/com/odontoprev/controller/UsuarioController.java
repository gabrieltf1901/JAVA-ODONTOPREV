package com.odontoprev.controller;

import com.odontoprev.dto.UsuarioDTO;
import com.odontoprev.model.Usuario;
import com.odontoprev.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuarios/list";           // note o plural aqui
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "usuarios/form";
    }

    @PostMapping
    public String create(@ModelAttribute("usuario") UsuarioDTO dto) {
        usuarioService.create(dto);
        return "redirect:/login";
    }

    @GetMapping("/{id}/editar")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.findById(id));
        return "usuarios/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("usuario") UsuarioDTO dto) {
        usuarioService.update(id, dto);
        return "redirect:/usuarios";
    }

    @GetMapping("/{id}/excluir")
    public String delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/novo")
    public String novoUsuario(Model model, HttpServletRequest request) {
        model.addAttribute("usuario", new Usuario());
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf", token);
        return "usuarios/form";
    }



}
