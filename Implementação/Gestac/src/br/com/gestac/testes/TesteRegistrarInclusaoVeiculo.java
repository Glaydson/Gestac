package br.com.gestac.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.gestac.apresentacao.FronteiraRegistrarVeiculo;
import br.com.gestac.modelo.veiculo.Veiculo;
import br.com.gestac.modelo.veiculo.VeiculoBean;

public class TesteRegistrarInclusaoVeiculo {

	private FronteiraRegistrarVeiculo fronteira = new FronteiraRegistrarVeiculo();

	@Test
	public void testRegistrarVeiculoSucesso() {
		// Cria os objetos para o registro do veículo
		Veiculo veiculo = new Veiculo();
		veiculo.setPlacas("ABC-1234");
		veiculo.setMarca("Ford");
		veiculo.setMarca("Fiesta");
		veiculo.setCor("Preta");
		VeiculoBean vBean = new VeiculoBean();
		vBean.setVeiculo(veiculo);
		vBean.setTipoVeiculo("Empresa");
		fronteira.setBeanVeiculos(vBean);

		// Faz o registro do veículo
		fronteira.registrarVeiculo();

		Veiculo veiculoObtido = fronteira.buscarVeiculoPelaPlaca("ABC-1234");
		Veiculo veiculoEsperado = veiculo;
		assertEquals(veiculoEsperado, veiculoObtido);
	}
	
	@Test
	public void testRegistrarVeiculoCorNaoPreenchida() {
		// Cria os objetos para o registro do veículo
		Veiculo veiculo = new Veiculo();
		veiculo.setPlacas("ABC-1234");
		veiculo.setMarca("Ford");
		veiculo.setMarca("Fiesta");
		// veiculo.setCor("Preta");
		VeiculoBean vBean = new VeiculoBean();
		vBean.setVeiculo(veiculo);
		vBean.setTipoVeiculo("Empresa");
		fronteira.setBeanVeiculos(vBean);

		// Faz o registro do veículo
		fronteira.registrarVeiculo();

		Veiculo veiculoObtido = fronteira.buscarVeiculoPelaPlaca("ABC-1234");
		Veiculo veiculoEsperado = veiculo;
		assertEquals(veiculoEsperado, veiculoObtido);
	}

}
