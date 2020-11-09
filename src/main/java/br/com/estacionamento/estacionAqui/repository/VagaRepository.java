package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.estacionAqui.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{

}
