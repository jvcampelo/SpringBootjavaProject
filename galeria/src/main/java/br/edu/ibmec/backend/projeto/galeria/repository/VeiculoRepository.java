package br.edu.ibmec.backend.projeto.galeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.backend.projeto.galeria.model.Veiculo;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    
} 