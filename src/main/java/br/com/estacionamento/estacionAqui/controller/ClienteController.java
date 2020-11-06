package br.com.estacionamento.estacionAqui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.estacionAqui.model.Cliente;
import br.com.estacionamento.estacionAqui.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping(path = "/testeConsulta")
	public String teste() {
		List<Cliente> cliente = repository.findAll();
		return "ConsultaClientes";
	}
}
