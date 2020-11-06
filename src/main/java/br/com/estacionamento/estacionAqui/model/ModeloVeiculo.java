package br.com.estacionamento.estacionAqui.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class ModeloVeiculo {

	@Id
	private Integer id;

	@Column(name = "nome_model")
	private String modelo;

	@Column(name = "marca")
	private String marca;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
