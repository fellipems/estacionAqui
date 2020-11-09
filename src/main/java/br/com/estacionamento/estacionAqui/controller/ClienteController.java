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

import br.com.estacionamento.estacionAqui.model.Cliente;
import br.com.estacionamento.estacionAqui.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository cr;

	@GetMapping(path = "/consulta-todos-clientes")
	public ResponseEntity<List<Cliente>> consultaCliente() {
		return ResponseEntity.ok(cr.findAll());
	}

	@GetMapping(path = "/consulta-um-cliente/{id}")
	public ResponseEntity<Cliente> consultaUmCliente(@PathVariable("id") Long id) {
		return cr.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(path = "/cadastra-cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastraCliente(@RequestBody @Valid Cliente cli) {
		return cr.save(cli);
	}

	@PatchMapping(path = "/atualiza-cadastro/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {
		cliente.setId(id);
		return ResponseEntity.ok(cr.save(cliente));
	}

	@DeleteMapping(path = "/excluir-cliente/{id}")
	public ResponseEntity<Integer> excluirCliente(@PathVariable("id") Long id) {
		cr.deleteById(id);
		return ResponseEntity.ok(1);
	}
}
