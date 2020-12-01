package com.example.restfulwebservices;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        AcceptHeaderLocaleResolver localeResolver =  new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Bean
    public OpenAPI apiDocumentation() {
        return new OpenAPI()
                .info(new Info().title("Spring Boot RESTful Web Service")
                        .description("Spring Boot RESTful Web Services Demo")
                        .version("v0.0.1")
                        .contact(new Contact().email("get.shahzadsaddique@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
