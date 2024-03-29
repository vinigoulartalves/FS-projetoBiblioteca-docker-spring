package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import br.com.projeto.biblioteca.service.BibliotecarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;

    @PostMapping
    public BibliotecarioEntity salvaBibliotecario(@RequestBody BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioService.salvarBibliotecario(bibliotecarioEntity);
    }

    @GetMapping
    public List<BibliotecarioEntity> listaBibliotecarios() {
        return bibliotecarioService.listarBibliotecarios();
    }

    @DeleteMapping
    public String deletaBibliotecario(@RequestParam("id") Long id) {
        bibliotecarioService.deletarBibliotecario(id);
        return "Ação deletar concluída com sucesso";
    }

    @PutMapping
    public ResponseEntity<?> atualizaBibliotecario(@RequestBody BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioService.atualizarBibliotecario(bibliotecarioEntity);
    }
}
