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
import javax.validation.constraints.NotEmpty;

@Entity(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "placa", unique = true)
	@NotEmpty(message = "Placa não pode estar vazia!")
	private String placa;

	@Column(name = "cor")
	private String cor;

	@Column(name = "ano_veiculo")
	private Integer ano;

	@Column(name = "nome_modelo")
	private String modelo;

	@Column(name = "marca")
	private String marca;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_veiculo")
	private TipoVeiculo tipoVeiculo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_VEICULO_id_veiculo")
	private TipoVeiculoPreco precoPorTipo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TICKET_id_ticket")
	private Ticket ticket;

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

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public TipoVeiculoPreco getPrecoPorTipo() {
		return precoPorTipo;
	}

	public void setPrecoPorTipo(TipoVeiculoPreco precoPorTipo) {
		this.precoPorTipo = precoPorTipo;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
