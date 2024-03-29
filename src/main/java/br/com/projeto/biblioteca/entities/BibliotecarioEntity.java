package br.com.projeto.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bibliotecario")
@Data

public class BibliotecarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;
    private String senha;

}
