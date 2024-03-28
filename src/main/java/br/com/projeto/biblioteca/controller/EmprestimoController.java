package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.EmprestimoEntity;
import br.com.projeto.biblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoEntity salvaEmprestimo(@RequestBody EmprestimoEntity emprestimoEntity) {
        return emprestimoService.salvarEmprestimo(emprestimoEntity);
    }


}
