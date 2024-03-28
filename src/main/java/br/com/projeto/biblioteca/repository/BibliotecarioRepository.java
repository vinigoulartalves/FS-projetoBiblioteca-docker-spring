package br.com.projeto.biblioteca.repository;

import br.com.projeto.biblioteca.entities.BibliotecarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioEntity, Long> {

    @Modifying
    @Query("UPDATE BibliotecarioEntity bibliotecario " +
            "SET " +
            "bibliotecario.nome = :nome, " +
            "bibliotecario.email = :email, " +
            "bibliotecario.senha = :senha " +
            "WHERE bibliotecario.id = :id")
    void update(@Param("id") Long id,
                @Param("nome") String nome,
                @Param("email") String email,
                @Param("senha") String senha);

}
