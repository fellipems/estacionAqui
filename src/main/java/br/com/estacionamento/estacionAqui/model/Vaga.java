package br.com.estacionamento.estacionAqui.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "vaga")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_vaga")
	private TipoVeiculo vaga;
	
	@Column(name = "num_vaga")
	private Long numeroVaga;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusVaga status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEICULO_id_veiculo")
	private Veiculo veiculo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTACIONAMENTO_id_estacionamento")
	private List<Estacionamento> estacionamento; 
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Estacionamento> getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(List<Estacionamento> estacionamento) {
		this.estacionamento = estacionamento;
	}

	public Integer getId() {
		return id;
	}
  
	public void setId(Integer id) {
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
