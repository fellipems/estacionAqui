package br.com.estacionamento.estacionAqui.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "placa", nullable = false)
	private String placa;
	
	@Column(name = "cor")
	private String cor;
	
	@Column(name = "ano_veiculo")
	private int ano;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODELO_id_modelo")
	private List<ModeloVeiculo> modelo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_VEICULO_id_veiculo")
	private List<TipoVeiculoPreco> precoPorTipo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TICKET_id_ticket")
	private Ticket ticket;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
