package br.com.estacionamento.estacionAqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.estacionAqui.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
}
