package br.edu.ibmec.backend.projeto.galeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.backend.projeto.galeria.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    
}
