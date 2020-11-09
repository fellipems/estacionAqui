package br.com.estacionamento.estacionAqui.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.estacionAqui.model.Ticket;
import br.com.estacionamento.estacionAqui.repository.TicketRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketRepository tr;

	@GetMapping(path = "/consulta-todos-tickets")
	public ResponseEntity<List<Ticket>> consultaTicket() {
		return ResponseEntity.ok(tr.findAll());
	}

	@GetMapping(path = "/consulta-um-ticket/{id}")
	public ResponseEntity<Ticket> consultaUmTicket(@PathVariable("id") Long id) {
		return tr.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(path = "/cadastra-ticket")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket cadastraTicket(@RequestBody @Valid Ticket ticket) {
		return tr.save(ticket);
	}

	@PatchMapping(path = "/atualiza-ticket/{id}")
	public ResponseEntity<Ticket> atualizaTicket(@PathVariable("id") Long id, @Valid @RequestBody Ticket ticket) {
		ticket.setId(id);
		return ResponseEntity.ok(tr.save(ticket));
	}

	@DeleteMapping(path = "/excluir-ticket/{id}")
	public ResponseEntity<Integer> excluirTicket(@PathVariable("id") Long id) {
		tr.deleteById(id);
		return ResponseEntity.ok(1);
	}
}
