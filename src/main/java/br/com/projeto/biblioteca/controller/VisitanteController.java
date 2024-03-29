package br.com.projeto.biblioteca.controller;


import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.service.VisitanteService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visitante")
public class VisitanteController {

    private final VisitanteService visitanteService;

    @PostMapping
    public VisitanteEntity salvaVisitante(@RequestBody VisitanteEntity visitanteEntity) {
        return visitanteService.salvarVisitante(visitanteEntity);
    }

    @GetMapping
    public List<VisitanteEntity> listaVisitantes() {
        return visitanteService.listarVisitantes();
    }

    @DeleteMapping
    public String deletaVisitante(@RequestParam("id") Long id) {
        visitanteService.deletarVisitante(id);
        return "Ação deletar concluída com sucesso";
    }

    @PutMapping
    public ResponseEntity<?> atualizaVisitante(@RequestBody VisitanteEntity visitanteEntity) {
        return visitanteService.atualizarVisitante(visitanteEntity);
    }


}
