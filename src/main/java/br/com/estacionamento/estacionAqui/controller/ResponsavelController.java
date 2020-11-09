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

import br.com.estacionamento.estacionAqui.model.ResponsavelDoEstacionamento;
import br.com.estacionamento.estacionAqui.repository.ResponsavelRepository;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelRepository rr;

	@GetMapping(path = "/lista-responsavel")
	public List<ResponsavelDoEstacionamento> listaResponsavel() {
		return rr.findAll();
	}

	@PostMapping(path = "/cadastra-responsavel")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponsavelDoEstacionamento cadastraResponsavel(
			@RequestBody @Valid ResponsavelDoEstacionamento responsavelDoEstacionamento) {
		rr.save(responsavelDoEstacionamento);
		return responsavelDoEstacionamento;
	}

	@PatchMapping(path = "/atualiza-responsavel/{id}")
	public ResponseEntity<ResponsavelDoEstacionamento> atualizaCadastroResponsavel(@PathVariable("id") Long id,
			@Valid @RequestBody ResponsavelDoEstacionamento responsavelDoEstacionamento) {
		responsavelDoEstacionamento.setId(id);
		return ResponseEntity.ok(rr.save(responsavelDoEstacionamento));
	}

	@DeleteMapping(path = "/deleta-responsavel/{id}")
	public ResponseEntity<Integer> deletaResponsavel(@PathVariable("id") Long id) {
		rr.deleteById(id);
		return ResponseEntity.ok(1);
	}
}
