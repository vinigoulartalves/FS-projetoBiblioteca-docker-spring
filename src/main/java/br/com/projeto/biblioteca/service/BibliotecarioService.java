package br.com.projeto.biblioteca.service;


import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
