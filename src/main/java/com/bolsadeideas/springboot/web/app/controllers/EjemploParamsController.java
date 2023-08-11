package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

     @GetMapping
     public String index() {
         return "params/index";
     }

    // RequestParam para capturar queryParams (localhost:8080/params/string=?texto=angel)
    @GetMapping("/string")
    // @RequestParam(name="texto"
    public String param(
            @RequestParam(
                    // name = "texto" // -> nombre del queryParam
                    required = false, // -> indicar si el queryParam que se espera recibir es opcional o requerido (requerido por default)
                    defaultValue = "algún valor..." // -> si no se recibe, este el valor default
            ) String texto, // -> nombre del queryParam
            Model model
    ) {

        model.addAttribute("resultado", String.format("El texto enviado es: %s", texto));

        return "params/ver";
    }

    // (localhost:8080/params/string=?texto=angel&numero=10)
    @GetMapping("/mix-params")
    // @RequestParam(name="texto"
    public String param(
            @RequestParam() String saludo,
            @RequestParam() Integer numero,
            Model model
    ) {

        model.addAttribute("resultado", String.format("El saludo enviado es: '%s' y el número es '%d'", saludo, numero));

        return "params/ver";
    }

    // (localhost:8080/params/string=?texto=angel&numero=10)
    @GetMapping("/mix-params-request")
    // @RequestParam(name="texto"
    public String param(HttpServletRequest request, Model model) {

         String saludo = request.getParameter("saludo");

         Integer numero = null;
         try {
             numero = Integer.parseInt(request.getParameter("numero"));
         } catch(NumberFormatException e) {
            numero = 0;
         }

        model.addAttribute("resultado", String.format("El saludo enviado es: '%s' y el número es '%d'", saludo, numero));

        return "params/ver";
    }

}
