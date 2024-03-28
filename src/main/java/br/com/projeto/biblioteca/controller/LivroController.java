package br.com.projeto.biblioteca.controller;


import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public LivroEntity salvaLivro(@RequestBody LivroEntity livroEntity) {
        return livroService.salvarLivro(livroEntity);
    }

}
