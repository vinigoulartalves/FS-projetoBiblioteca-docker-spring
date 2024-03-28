package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.service.VisitanteService;
import lombok.NoArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visitante")
public class VisitanteController {

    private final VisitanteService visitanteService;

    @PostMapping
    public VisitanteEntity salvaVisitante(@RequestBody VisitanteEntity visitanteEntity) {
        return visitanteService.salvarVisitante(visitanteEntity);
    }
}
