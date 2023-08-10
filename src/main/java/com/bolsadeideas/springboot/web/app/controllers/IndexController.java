package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();

        usuario.setNombre("Angel");
        usuario.setApellido("Travieso");
        usuario.setEmail("correo@correo.com");

        // Pasar datos a la vista
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
//        List<Usuario> usuarios = new ArrayList<>();

//        usuarios.add(new Usuario("Angel", "Travieso", "correo@correo.com"));

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Angel", "Travieso", "correo@correo.com"),
                new Usuario("Jon", "Doe", "correo2@correo.com"),
                new Usuario("Maria", "Perez", "correo3@correo.com")
        );

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }

}
