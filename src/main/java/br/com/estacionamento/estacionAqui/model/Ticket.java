package br.com.estacionamento.estacionAqui.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name = "hora_entrada")
	public Calendar horaEntrada;
	
	@Column(name = "hora_saida")
	public Calendar horaSaida;
	
	@Column(nullable = false)
	public String placa;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
}
