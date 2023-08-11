package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

     @GetMapping
     public String index() {
         return "params/index";
     }

    @GetMapping("/string")
    // @RequestParam(name="texto"
    public String param(
            @RequestParam(
                    // name = "texto" // -> nombre del queryParam
                    required = false, // -> indicar si el queryParam que se espera recibir es opcional o requerido (requerido por default)
                    defaultValue = "algún valor..." // -> si no se recibe, este el valor default
            ) String texto, // -> nombre del queryParam
            Model model
    ) { // RequestParam para capturar queryParams (localhost:8080/params/string=?texto=angel)

        model.addAttribute("resultado", String.format("El texto enviado es: %s", texto));

        return "params/ver";
    }

}
