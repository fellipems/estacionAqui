package br.com.estacionamento.estacionAqui.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "estacionamento")
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "hora_entrada")
	private Calendar horaEntrada;
	
	@Column(name = "hora_saida")
	private Calendar horaSaida;
	
	@Column(name = "tipo_pagamento")
	private String tipoPagamento;
	
	@Column(name = "qtd_vagas")
	private int qtdVagas;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESPONSAVEL_id_responsavel")
	private ResponsavelDoEstacionamento responsavel;
	
	public ResponsavelDoEstacionamento getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelDoEstacionamento responsavel) {
		this.responsavel = responsavel;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

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

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}
