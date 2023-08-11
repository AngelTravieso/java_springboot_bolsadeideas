package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametros de la ruta (@PathVariable)");
        return "variables/index";
    }

    // (http://localhost:8080/string/1234)
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable() String texto, Model model) {
        model.addAttribute("titulo", "Recibir PathVariable");
        model.addAttribute("resultado", String.format("El texto enviado en la ruta es: %s", texto));
        return "variables/ver";
    }

    // (http://localhost:8080/string/1234)
    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable() String texto, @PathVariable() Integer numero,  Model model) {
        model.addAttribute("titulo", "Recibir PathVariable");
        model.addAttribute("resultado", String.format("El texto enviado en la ruta es: %s y el numero enviado en el path es: %d", texto, numero));

        return "variables/ver";
    }
}
