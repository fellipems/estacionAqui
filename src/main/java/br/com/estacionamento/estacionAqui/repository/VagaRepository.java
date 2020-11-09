package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.estacionAqui.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long>{

}
