package br.com.projeto.biblioteca.repository;

import br.com.projeto.biblioteca.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {

    @Modifying
    @Query("UPDATE MembroEntity membro " +
            "SET " +
            "membro.nome = :nome, " +
            "membro.endereco = :endereco, " +
            "membro.telefone = :telefone " +
            "WHERE membro.id = :id")
    void update(@Param("id") Long id,
                @Param("nome") String nome,
                @Param("endereco") String endereco,
                @Param("telefone") String telefone
    );
}


