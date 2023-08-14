package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app") // => ruta de primer nivel, genérica para el controlador
public class IndexController {

    // @Value() -> busca en el application.properties una propiedad con el nombre dado para usar su valor
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoindex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    // @RequestMapping(value = "/index", method = RequestMethod.GET) // => por defecto es get
    @GetMapping({"/index", "/", "/home", ""}) // => mapeado a varias rutas
    // Model model => model.addAttribute("key", "value");
    // ModelMap model
    // Map<String, Object> map => map.put("key", "value");
    // ModelAndView mv => mv.addObject("key", "value") => return mv;
    public String index(Model model) {
        model.addAttribute("titulo", textoindex);
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
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
//        List<Usuario> usuarios = new ArrayList<>();

//        usuarios.add(new Usuario("Angel", "Travieso", "correo@correo.com"));

        /*List<Usuario> usuarios = Arrays.asList(
                new Usuario("Angel", "Travieso", "correo@correo.com"),
                new Usuario("Jon", "Doe", "correo2@correo.com"),
                new Usuario("Maria", "Perez", "correo3@correo.com")
        );*/

        model.addAttribute("titulo", textoListar);
        // model.addAttribute("usuarios", usuarios);

        return "listar";
    }

    // ModelAttribute hace que la propiedad este disponible en todo el controlador, a todos los metodos del controlador y se puede usar en las plantilals que se necesiten
    @ModelAttribute("usuarios") // nombre con el que queremos pasar a la vista
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Angel", "Travieso", "correo@correo.com"),
                new Usuario("Jon", "Doe", "correo2@correo.com"),
                new Usuario("Maria", "Perez", "correo3@correo.com")
        );

        return usuarios;
    }

}
