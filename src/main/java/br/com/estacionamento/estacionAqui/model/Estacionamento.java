package br.com.estacionamento.estacionAqui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private Long id;
	
	@Column(name = "qtd_vagas")
	private int qtdVagas;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_vaga")
	private StatusVaga statusVaga;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESPONSAVEL_id_responsavel")
	private ResponsavelDoEstacionamento responsavel;
	
	public StatusVaga getStatusVaga() {
		return statusVaga;
	}

	public void setStatusVaga(StatusVaga statusVaga) {
		this.statusVaga = statusVaga;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
