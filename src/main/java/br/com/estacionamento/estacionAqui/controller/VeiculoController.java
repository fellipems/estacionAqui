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

import br.com.estacionamento.estacionAqui.model.Veiculo;
import br.com.estacionamento.estacionAqui.repository.VeiculoRepository;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController {

	@Autowired
	private VeiculoRepository vr;

	@GetMapping(path = "/lista-veiculos")
	public List<Veiculo> listaVeiculos() {
		return vr.findAll();
	}

	@GetMapping(path = "/consulta-um-veiculo/{id}")
	public ResponseEntity<Veiculo> consultaUmVeiculo(@PathVariable("id") Long id) {
		return vr.findById(id).map(record -> ResponseEntity.ok().body(record)) // record = linha que estamos retornando
				.orElse(ResponseEntity.notFound().build()); // caso não ache, retorne um notFound
	}

	@PostMapping(path = "/cadastra-veiculo")
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo cadastraVeiculo(@RequestBody @Valid Veiculo veiculo) {
		vr.save(veiculo);
		return veiculo;
	}

	@PatchMapping(path = "/atualiza-veiculo/{id}")
	public ResponseEntity<Veiculo> atualizaCadastroVeiculo(@PathVariable("id") Long id,
			@Valid @RequestBody Veiculo veiculo) {
		veiculo.setId(id);
		return ResponseEntity.ok(vr.save(veiculo)); // se tem o id ele atualiza os dados, se não tiver ele cria um novo
	}

	@DeleteMapping(path = "/deleta-veiculo/{id}")
	public ResponseEntity<Integer> deletaVeiculo(@PathVariable("id") Long id) {
		vr.deleteById(id);
		return ResponseEntity.ok(1);
	}

}
