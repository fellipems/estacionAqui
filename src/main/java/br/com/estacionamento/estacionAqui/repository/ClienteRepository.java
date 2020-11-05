package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.estacionAqui.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
