package br.com.estacionamento.estacionAqui.model;

import java.util.Calendar;

import org.springframework.data.annotation.Id;

public class Ticket {

	@Id
	public Long id;
	public Calendar horaEntrada;
	public Calendar horaSaida;
	public String veiculo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Calendar horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Calendar getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Calendar horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

}
