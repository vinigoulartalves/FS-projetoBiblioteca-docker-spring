package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LivroService {

    private final LivroRepository livroRepository;

    public LivroEntity salvarLivro(LivroEntity livroEntity) {
        return livroRepository.save(livroEntity);
    }

}
