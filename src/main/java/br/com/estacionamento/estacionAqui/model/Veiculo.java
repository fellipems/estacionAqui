package br.com.estacionamento.estacionAqui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veiculo")
	private Integer id;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "cor")
	private String cor;
	
	@Column(name = "ano_veiculo")
	private int ano;
	
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tipo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODELO_id_modelo")
	private ModeloVeiculo modelo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_VEICULO_id_veiculo")
	private TipoVeiculoPreco precoPorTipo;
	
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

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}
}
