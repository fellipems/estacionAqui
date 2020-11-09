package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.estacionAqui.model.Cliente;

@Repository   // classe para interagir com banco de dados
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	 
}
