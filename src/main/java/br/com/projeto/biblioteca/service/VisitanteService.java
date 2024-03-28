package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.repository.VisitanteRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;

    public VisitanteEntity salvarVisitante(VisitanteEntity visitanteEntity) {
        return visitanteRepository.save(visitanteEntity);
    }
}
