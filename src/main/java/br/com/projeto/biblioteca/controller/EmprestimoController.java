package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import br.com.projeto.biblioteca.entities.EmprestimoEntity;
import br.com.projeto.biblioteca.entities.VisitanteEntity;
import br.com.projeto.biblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoEntity salvaEmprestimo(@RequestBody EmprestimoEntity emprestimoEntity) {
        return emprestimoService.salvarEmprestimo(emprestimoEntity);
    }

    @GetMapping
    public List<EmprestimoEntity> listaEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @DeleteMapping
    public String deletaEmprestimo(@RequestParam("id") Long id) {
        emprestimoService.deletarEmprestimo(id);
        return "Ação deletar concluída com sucesso";
    }

    @PutMapping
    public ResponseEntity<?> atualizaEmprestimo(@RequestBody EmprestimoEntity emprestimoEntity) {
        return emprestimoService.atualizarEmprestimo(emprestimoEntity);
    }


}
