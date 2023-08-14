package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Redirigir a una ruta de mi aplicación
        // return "redirect:/app/index"; -> // redirect cambia la ruta url
        // return "patch:/app/index"; // -> forward no cambiar la url en el navegador y es para rutas propias del proyecto, forward dispara un RequestDispatcher.forward() del Api Servlet

        // Redirigir a una web externa
        return "redirect:https://www.google.com";
    }

}
