package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") // => ruta de primer nivel, genérica para el controlador
public class IndexController {

    // @RequestMapping(value = "/index", method = RequestMethod.GET) // => por defecto es get
    @GetMapping({"/index", "/", "/home", ""}) // => mapeado a varias rutas
    // Model model => model.addAttribute("key", "value");
    // ModelMap model
    // Map<String, Object> map => map.put("key", "value");
    // ModelAndView mv => mv.addObject("key", "value") => return mv;
    public String index(Model model) {
        model.addAttribute("titulo", "hola spring framework");
        return "index";
    }

}
