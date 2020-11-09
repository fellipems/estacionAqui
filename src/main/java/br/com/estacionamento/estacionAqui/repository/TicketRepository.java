package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.estacionAqui.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
}
