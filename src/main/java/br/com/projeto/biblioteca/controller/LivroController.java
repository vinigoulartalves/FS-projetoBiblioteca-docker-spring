package br.com.projeto.biblioteca.controller;


import br.com.projeto.biblioteca.entities.EmprestimoEntity;
import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public LivroEntity salvaLivro(@RequestBody LivroEntity livroEntity) {
        return livroService.salvarLivro(livroEntity);
    }

    @GetMapping
    public List<LivroEntity> listaLivros() {
        return livroService.listarLivros();
    }

    @DeleteMapping
    public String deletaLivro(@RequestParam("id") Long id) {
        livroService.deletarLivro(id);
        return "Ação deletar concluída com sucesso";
    }

}
