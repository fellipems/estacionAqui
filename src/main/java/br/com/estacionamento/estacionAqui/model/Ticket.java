package br.com.estacionamento.estacionAqui.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

@Entity(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ticket")
	public Integer id;
	
	@Column(name = "hora_entrada")
	public Calendar horaEntrada;
	
	@Column(name = "hora_saida")
	public Calendar horaSaida;
	public String placa;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VAGA_idVAGA")
	private Vaga vaga;
	
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
