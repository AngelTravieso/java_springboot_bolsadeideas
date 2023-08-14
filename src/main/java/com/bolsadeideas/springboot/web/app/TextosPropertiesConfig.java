package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// -> @Configuration para indicar que es una clase de configuración
// -> @PropertySources recibe un arreglo de @ProperySource con el nombre del archivo property extra
@Configuration
@PropertySources({
        @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {
}
