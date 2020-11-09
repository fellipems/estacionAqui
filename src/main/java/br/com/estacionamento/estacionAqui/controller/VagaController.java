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

import br.com.estacionamento.estacionAqui.model.Vaga;
import br.com.estacionamento.estacionAqui.repository.VagaRepository;

@RestController
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaRepository vr;

	@GetMapping(path = "/consulta-todas-vagas")
	public ResponseEntity<List<Vaga>> consultaVaga() {
		return ResponseEntity.ok(vr.findAll());
	}

	@GetMapping(path = "/consulta-uma-vaga/{id}")
	public ResponseEntity<Vaga> consultaUmaVaga(@PathVariable("id") Long id) {
		return vr.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(path = "/cadastra-vaga")
	@ResponseStatus(HttpStatus.CREATED)
	public Vaga cadastraVaga(@RequestBody @Valid Vaga vaga) {
		return vr.save(vaga);
	}

	@PatchMapping(path = "/atualiza-vaga/{id}")
	public ResponseEntity<Vaga> atualizaVaga(@PathVariable("id") Long id, @Valid @RequestBody Vaga vaga) {
		vaga.setId(id);
		return ResponseEntity.ok(vr.save(vaga));
	}

	@DeleteMapping(path = "/excluir-vaga/{id}")
	public ResponseEntity<Integer> excluirVaga(@PathVariable("id") Long id) {
		vr.deleteById(id);
		return ResponseEntity.ok(1);
	}
}
