package br.edu.ibmec.backend.projeto.galeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nome do fabricante é obrigatório.")
    private String nome;

    @Column(name= "data_criação")
    private LocalDate dataCriacao = LocalDate.now();
}