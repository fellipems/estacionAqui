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

import br.com.estacionamento.estacionAqui.model.Estacionamento;
import br.com.estacionamento.estacionAqui.repository.EstacionamentoRepository;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoRepository er;

	@GetMapping(path = "/consulta-qtd-vagas")
	public ResponseEntity<List<Estacionamento>> consultaVagas() {
		return ResponseEntity.ok(er.findAll());
	}

	@PostMapping(path = "/cadastra-vaga")
	@ResponseStatus(HttpStatus.CREATED)
	public Estacionamento cadastraCliente(@RequestBody @Valid Estacionamento estacionamento) {
		return er.save(estacionamento);
	}

	@PatchMapping(path = "/atualiza-vaga/{id}")
	public ResponseEntity<Estacionamento> atualizaTicket(@PathVariable("id") Long id,
			@Valid @RequestBody Estacionamento estacionamento) {
		estacionamento.setId(id);
		return ResponseEntity.ok(er.save(estacionamento));
	}

	@DeleteMapping(path = "/excluir-vaga/{id}")
	public ResponseEntity<Integer> excluirTicket(@PathVariable("id") Long id) {
		er.deleteById(id);
		return ResponseEntity.ok(1);
	}
}
