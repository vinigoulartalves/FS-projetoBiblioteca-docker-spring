package br.com.projeto.biblioteca.repository;

import br.com.projeto.biblioteca.entities.EmprestimoEntity;
import br.com.projeto.biblioteca.entities.LivroEntity;
import br.com.projeto.biblioteca.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

    @Modifying
    @Query("UPDATE EmprestimoEntity emprestimo " +
            "SET " +
            "emprestimo.livro = :livro, " +
            "emprestimo.membro = :membro, " +
            "emprestimo.dataEmprestimo = :dataEmprestimo, " +
            "emprestimo.dataDevolucao = :dataDevolucao " +
            "WHERE emprestimo.id = :id")
    void update(@Param("id") Long id,
                @Param("livro") LivroEntity livro,
                @Param("membro") MembroEntity membro,
                @Param("dataEmprestimo") LocalDate dataEmprestimo,
                @Param("dataDevolucao") LocalDate dataDevolucao);

}
