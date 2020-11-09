package br.com.estacionamento.estacionAqui.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.estacionamento.estacionAqui.model.Estacionamento;
import br.com.estacionamento.estacionAqui.model.Ticket;
// Tentativa de calcular o ticket, pedir dicas para o Daniel novamente. Desconsiderar esse calculo no momento
public class CalculaValorTicket {

	private double valor;
	private int tik;

	public static double CalculaValores(List<Estacionamento> valores, Optional<Ticket> vagaOcupada) throws ParseException {
		List<CalculaValorTicket> calcula = new ArrayList<CalculaValorTicket>();
		long tempo1 = vagaOcupada.get().getHoraEntrada().getTime();
		long tempo2 = vagaOcupada.get().getHoraSaida().getTime();
		long diff = tempo2 - tempo1;
		long diffMin = diff / 60000;
		vagaOcupada.get().setValor((double) 0);
		for (int i = 0; i < calcula.size(); i++) {
			double b = calcula.get(i).tik * calcula.get(i).valor;
			vagaOcupada.get().setValor(vagaOcupada.get().getValor() + b);
		}
		return vagaOcupada.get().getValor();
	}
}
