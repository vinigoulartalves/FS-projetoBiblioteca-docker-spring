package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;

    public VisitanteEntity salvarVisitante(VisitanteEntity visitanteEntity) {
        return visitanteRepository.save(visitanteEntity);
    }

    public List<VisitanteEntity> listarVisitantes() {
        return visitanteRepository.findAll();
    }

    public void deletarVisitante(Long id) {
        visitanteRepository.deleteById(id);
    }

    public ResponseEntity<?> atualizarVisitante(VisitanteEntity visitanteEntity) {
        if (!visitanteRepository.existsById(visitanteEntity.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id: " + visitanteEntity.getId() + " não encontrada.");
        }
        visitanteRepository.update(
                visitanteEntity.getId(),
                visitanteEntity.getNome(),
                visitanteEntity.getTelefone()
        );
        Optional<VisitanteEntity> visitante = visitanteRepository.findById(visitanteEntity.getId());
        return ResponseEntity.status(HttpStatus.OK).body(visitante.get());
    }


}
