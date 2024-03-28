package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import br.com.projeto.biblioteca.service.BibliotecarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;

    @PostMapping
    public BibliotecarioEntity salvaBibliotecario(@RequestBody BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioService.salvarBibliotecario(bibliotecarioEntity);
    }
}
