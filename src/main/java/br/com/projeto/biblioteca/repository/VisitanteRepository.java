package br.com.projeto.biblioteca.repository;


import br.com.projeto.biblioteca.entities.VisitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteEntity, Long> {


    @Modifying
    @Query("UPDATE VisitanteEntity visitante " +
            "SET " +
            "visitante.nome = :nome, " +
            "visitante.telefone = :telefone " +
            "WHERE visitante.id = :id")
    void update(@Param("id") Long id,
                @Param("nome") String nome,
                @Param("telefone") String telefone);

}
