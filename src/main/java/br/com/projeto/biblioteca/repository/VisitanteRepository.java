package br.com.projeto.biblioteca.repository;


import br.com.projeto.biblioteca.entities.VisitanteEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteEntity, Long> {


    @Modifying
    @Query("UPDATE VisitanteEntity v " +
            "SET v.nome = :nome, v.telefone = :telefone " +
            "WHERE v.id = :id"
    )

    @Transactional
    void update(Long id,
                String nome,
                String telefone
    );

}
