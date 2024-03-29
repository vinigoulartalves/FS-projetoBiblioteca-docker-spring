package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    public MembroEntity salvarMembros(MembroEntity membroEntity) {
        return membroRepository.save(membroEntity);
    }

    public List<MembroEntity> listarMembros() {
        return membroRepository.findAll();
    }

    public void deletarMembro(Long id) {
        membroRepository.deleteById(id);
    }

    public ResponseEntity<?> atualizarMembro(MembroEntity membroEntity) {
        if (!membroRepository.existsById(membroEntity.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id: " + membroEntity.getId() + " não encontrada.");
        }
        membroRepository.update(
                membroEntity.getId(),
                membroEntity.getNome(),
                membroEntity.getEndereco(),
                membroEntity.getTelefone()
        );
        Optional<MembroEntity> membro = membroRepository.findById(membroEntity.getId());
        return ResponseEntity.status(HttpStatus.OK).body(membro.get());
    }
}
