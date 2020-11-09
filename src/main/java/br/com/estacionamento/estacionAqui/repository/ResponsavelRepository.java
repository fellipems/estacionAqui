package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.estacionAqui.model.ResponsavelDoEstacionamento;

@Repository
public interface ResponsavelRepository extends JpaRepository<ResponsavelDoEstacionamento, Long> {

}
