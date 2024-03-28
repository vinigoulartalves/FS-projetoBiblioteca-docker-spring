package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class LivroService {

    private final LivroRepository livroRepository;

    public LivroEntity salvarLivro(LivroEntity livroEntity) {
        return livroRepository.save(livroEntity);
    }

    public List<LivroEntity> listarLivros() {
        return livroRepository.findAll();
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }


}
