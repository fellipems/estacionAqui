package br.com.estacionamento.estacionAqui.model;

import org.springframework.data.annotation.Id;

public class Vaga {

	@Id
	private Long id;
	private TipoVeiculo vaga;
	private Long numeroVaga;
	private StatusVaga status;
	
	public Long getId() {
		return id;
	}
  
	public void setId(Long id) {
		this.id = id;
	}

	public TipoVeiculo getVaga() {
		return vaga;
	}

	public void setVaga(TipoVeiculo vaga) {
		this.vaga = vaga;
	}

	public Long getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(Long numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public StatusVaga getStatus() {
		return status;
	}

	public void setStatus(StatusVaga status) {
		this.status = status;
	}

}
