package br.com.gestac.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.gestac.modelo.veiculo.Veiculo;

public class VeiculoDAO {

	private static List<Veiculo> veiculos = new ArrayList<Veiculo>();

	public static void adicionar(Veiculo veiculo) {
		veiculos.add(veiculo);

	}

	public static Veiculo buscarPelaPlaca(String placas) throws Exception {
		Veiculo veiculo = null;
		for (Veiculo v : veiculos) {
			if (v.getPlacas().equals(placas)) {
				veiculo = v;
			}
		}
		if (veiculo == null)
			throw new Exception("Veiculo não encontrado");
		return veiculo;
	}

	public static List<Veiculo> buscarVeiculos() {
		return veiculos;
	}

}
