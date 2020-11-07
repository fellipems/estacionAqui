package br.com.estacionamento.estacionAqui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.estacionAqui.model.Cliente;
import br.com.estacionamento.estacionAqui.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {  // receber requisições. desenvolver nossos endpoints
	
	@Autowired
	private ClienteRepository cr;
	
	@GetMapping
	@RequestMapping("/listaClientes")
	public List<Cliente> listaCliente() {
		return cr.findAll();
	}
	
	@PostMapping
	@RequestMapping("/cadastraCliente")
	@ResponseStatus(HttpStatus.CREATED)  // devolver status CREATED com sucesso
	public Cliente cadastraCliente(@RequestBody Cliente cli) {  // @RequestBody corpo da nossa requisição vai ser convertido para objeto java
		cr.save(cli);
		return cli;
	}
}
