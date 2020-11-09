package br.com.estacionamento.estacionAqui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "tipo_veiculo_preco")
public class TipoVeiculoPreco {
	
	@Id
	@Column(name = "id_tipo")
	private Integer id;
	
	@Column(name = "preco_tipo")
	private double preco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoVeiculo tipo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

}
