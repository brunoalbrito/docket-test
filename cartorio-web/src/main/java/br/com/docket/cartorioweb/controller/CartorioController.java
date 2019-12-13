package br.com.docket.cartorioweb.controller;


import br.com.docket.cartorioweb.model.Cartorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Controller
public class CartorioController {

    @GetMapping
    String oi(Model model){
        System.out.println("Passou aqui");
        model.addAttribute("cartorios", Arrays.asList(Cartorio.of(1, "Caucaia")));
        return  "index";
    }
}
