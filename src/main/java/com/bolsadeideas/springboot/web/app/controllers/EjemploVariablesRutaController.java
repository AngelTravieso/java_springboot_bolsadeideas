package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EjemploVariablesRutaController {

    // (http://localhost:8080/string/1234)
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable() String texto, Model model) {
        model.addAttribute("titulo", "Recibir PathVariable");
        model.addAttribute("resultado", String.format("El texto enviado en la ruta es: %s", texto));
        return "variables/ver";
    }
}
