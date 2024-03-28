package br.com.projeto.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "emprestimo")
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private LivroEntity livro;

    @ManyToOne
    private MembroEntity membro;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}
