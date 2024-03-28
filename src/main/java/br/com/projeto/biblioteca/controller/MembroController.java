package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/membro")
public class MembroController {

    private final MembroService membroService;

    @PostMapping
    public MembroEntity salvaMembro(@RequestBody MembroEntity membroEntity) {
        return membroService.salvarMembros(membroEntity);
    }


}
