package br.com.estacionamento.estacionAqui.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.estacionAqui.model.Veiculo;
import br.com.estacionamento.estacionAqui.repository.VeiculoRepository;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController{
	
	@Autowired
	private VeiculoRepository vr;
	
	@GetMapping(path = "/lista-veiculos")
	public List<Veiculo> listaVeiculos(){
		return vr.findAll();
	}
	
	@PostMapping(path = "/cadastra-veiculo")
	@ResponseStatus(HttpStatus.CREATED)  
	public Veiculo cadastraVeiculo(@RequestBody @Valid Veiculo veiculo) { 
		vr.save(veiculo);
		return veiculo;
	}
	
	@DeleteMapping(path = "/deleta-veiculo")
	public Veiculo deletaVeiculo(@RequestBody Veiculo veiculo) {
		vr.delete(veiculo);
		return veiculo;
	}
	
}
