package br.com.projeto.biblioteca.service;


import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;


    public BibliotecarioEntity salvarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioRepository.save(bibliotecarioEntity);
    }

    public List<BibliotecarioEntity> listarBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public void deletarBibliotecario(Long id) {
        bibliotecarioRepository.deleteById(id);
    }

    public ResponseEntity<?> atualizarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        if (!bibliotecarioRepository.existsById(bibliotecarioEntity.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id: " + bibliotecarioEntity.getId() + " não encontrada.");
        }
        bibliotecarioRepository.update(
                bibliotecarioEntity.getId(),
                bibliotecarioEntity.getNome(),
                bibliotecarioEntity.getEmail(),
                bibliotecarioEntity.getSenha()
        );
        Optional<BibliotecarioEntity> bibliotecario = bibliotecarioRepository.findById(bibliotecarioEntity.getId());
        return ResponseEntity.status(HttpStatus.OK).body(bibliotecario.get());
    }

}

