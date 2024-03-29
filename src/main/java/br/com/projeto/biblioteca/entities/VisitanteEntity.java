package br.com.projeto.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "visitante")
@Data
public class VisitanteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;

}
