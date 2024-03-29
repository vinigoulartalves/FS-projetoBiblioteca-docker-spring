package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<?> atualizarLivro(LivroEntity livroEntity) {
        if (!livroRepository.existsById(livroEntity.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id: " + livroEntity.getId() + " não encontrada.");
        }
        livroRepository.update(
                livroEntity.getId(),
                livroEntity.getTitulo(),
                livroEntity.getAnoPublicacao()
        );
        Optional<LivroEntity> livro = livroRepository.findById(livroEntity.getId());
        return ResponseEntity.status(HttpStatus.OK).body(livro.get());
    }

}
