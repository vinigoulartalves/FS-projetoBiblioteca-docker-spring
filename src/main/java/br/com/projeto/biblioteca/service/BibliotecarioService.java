package br.com.projeto.biblioteca.service;


import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import br.com.projeto.biblioteca.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;


    public BibliotecarioEntity salvarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioRepository.save(bibliotecarioEntity);
    }
}
