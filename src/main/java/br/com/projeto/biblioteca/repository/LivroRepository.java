package br.com.projeto.biblioteca.repository;

import br.com.projeto.biblioteca.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    @Modifying
    @Query("UPDATE LivroEntity livro " +
            "SET " +
            "livro.titulo = :titulo, " +
            "livro.anoPublicacao = :ano_publicacao " +
            "WHERE livro.id = :id")
    void update(@Param("id") Long id,
                @Param("titulo") String titulo,
                @Param("ano_publicacao") Long anoPublicacao
    );


}
