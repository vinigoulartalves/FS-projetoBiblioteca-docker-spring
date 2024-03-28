package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
