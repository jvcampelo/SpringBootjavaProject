package br.edu.ibmec.backend.projeto.galeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nome do veículo é obrigatório.")
    private String nome;

    @NotNull(message = "Tipo do veículo é obrigatório (Carro ou Moto).")
    private String tipo;

    @Column(name = "data_criação")
    private LocalDate dataCriacao = LocalDate.now();

    @NotNull(message = "descriçaõ obrigatoria")
    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    
}
