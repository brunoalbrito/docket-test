package br.com.docket.cartorioweb.controller;


import br.com.docket.cartorioweb.dto.CartorioDTO;
import br.com.docket.cartorioweb.model.Cartorio;
import br.com.docket.cartorioweb.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CartorioController {

    @Autowired
    private CartorioService service;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("cartorios", service.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("cartorio", CartorioDTO.getInstance());
        return "/cartorio-adiciona-e-edita";
    }

    @PostMapping("/save")
    public String save(@Valid Cartorio cartorio, Model model) {
        if (cartorio.getId() == 0) service.save(cartorio);
        else service.edit(cartorio);

        model.addAttribute("cartorios", service.findAll());
        return "/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Cartorio cartorio = service.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid cartorio id" + id));
        model.addAttribute("cartorio", cartorio);

        return "/cartorio-adiciona-e-edita";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Cartorio cartorio = service.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid cartorio id" + id));
        service.delete(cartorio);
        model.addAttribute("cartorios", service.findAll());
        return "index";
    }
}
