package br.com.projeto.biblioteca.service;

import br.com.projeto.biblioteca.entities.EmprestimoEntity;
import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.repository.EmprestimoRepository;
import br.com.projeto.biblioteca.repository.LivroRepository;
import br.com.projeto.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final MembroRepository membroRepository;


    public EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimoEntity) {
        validaEmprestimo(emprestimoEntity);
        return emprestimoRepository.save(emprestimoEntity);
    }

    public void validaEmprestimo(EmprestimoEntity emprestimoEntity) {

        if (!livroRepository.existsById(emprestimoEntity.getLivro().getId())) {
            throw new RuntimeException();
        } else {
            Optional<LivroEntity> livroEntity = livroRepository.findById(emprestimoEntity.getLivro().getId());
            emprestimoEntity.setLivro(livroEntity.get());
        }

        if (!membroRepository.existsById(emprestimoEntity.getMembro().getId())) {
            throw new RuntimeException();
        } else {
            Optional<MembroEntity> membroEntity = membroRepository.findById(emprestimoEntity.getMembro().getId());
            emprestimoEntity.setMembro(membroEntity.get());
        }
    }

    public List<EmprestimoEntity> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }


}
