package br.com.projeto.biblioteca.controller;

import br.com.projeto.biblioteca.entities.MembroEntity;
import br.com.projeto.biblioteca.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/membro")
public class MembroController {

    private final MembroService membroService;

    @PostMapping
    public MembroEntity salvaMembro(@RequestBody MembroEntity membroEntity) {
        return membroService.salvarMembros(membroEntity);
    }

    @GetMapping
    public List<MembroEntity> listaMembros() {
        return membroService.listarMembros();
    }

    @DeleteMapping
    public String deletaMembro(@RequestParam("id") Long id) {
        membroService.deletarMembro(id);
        return "Ação deletar concluída com sucesso";
    }

    @PutMapping
    public ResponseEntity<?> atualizaMembro(@RequestBody MembroEntity membroEntity) {
        return membroService.atualizarMembro(membroEntity);
    }


}
