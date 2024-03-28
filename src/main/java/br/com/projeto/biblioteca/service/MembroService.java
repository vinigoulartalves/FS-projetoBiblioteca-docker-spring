package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    public MembroEntity salvarMembros(MembroEntity membroEntity) {
        return membroRepository.save(membroEntity);
    }

}