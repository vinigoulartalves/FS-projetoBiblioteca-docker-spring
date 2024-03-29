package br.com.projeto.biblioteca.repository;

import br.com.projeto.biblioteca.entities.MembroEntity;
import jakarta.transaction.Transactional;
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
            "WHERE membro.id = :id"
    )

    @Transactional
    void update(Long id,
                String nome,
                String endereco,
                String telefone
    );
}


