package br.com.gestac.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.gestac.modelo.funcionario.FuncionarioBean;
import br.com.gestac.modelo.usuario.TipoUsuario;
import br.com.gestac.modelo.usuario.UsuarioBean;
import br.com.gestac.modelo.veiculo.Veiculo;
import br.com.gestac.modelo.veiculo.VeiculoBean;
import br.com.gestac.modelo.veiculo.VeiculoEmpresa;
import br.com.gestac.modelo.veiculo.VeiculoFuncionario;
import br.com.gestac.util.Util;

public class TesteRegistrarVeiculo {

	@Before
	public void setUp() throws Exception {
		UsuarioBean.adicionarUsuarios();
		FuncionarioBean.adicionarFuncionarios();
		VeiculoBean.adicionarVeiculos();

	}

	@Test
	public void testRegistrarVeiculoEmpresaSucesso() {
		// Cria um novo veículo
		Veiculo veiculo = new VeiculoEmpresa();
		veiculo.setPlacas("ABC-1234");
		veiculo.setMarca("Ford");
		veiculo.setModelo("Fiesta");
		veiculo.setCor("Preta");
		VeiculoBean vBean = new VeiculoBean();
		vBean.setVeiculo(veiculo);
		vBean.setTipoVeiculo("Empresa");
		try {
			vBean.registrarVeiculo();
			Veiculo veiculoObtido = vBean.buscarVeiculoPelaPlaca("ABC-1234");
			Veiculo veiculoEsperado = veiculo;
			assertEquals(veiculoEsperado, veiculoObtido);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testRegistrarVeiculoFuncionarioSucesso() {
		// Cria um novo veículo
		Veiculo veiculo = new VeiculoFuncionario();
		veiculo.setPlacas("ABC-5678");
		veiculo.setMarca("Citroen");
		veiculo.setModelo("C4");
		veiculo.setCor("Preta");
		VeiculoBean vBean = new VeiculoBean();
		vBean.setVeiculo(veiculo);
		vBean.setTipoVeiculo("Funcionário");
		try {
			vBean.registrarVeiculo();
			VeiculoFuncionario veiculoObtido = (VeiculoFuncionario) vBean
					.buscarVeiculoPelaPlaca("ABC-5678");
			String usuarioLogado = Util
					.obterUsuarioLogado(TipoUsuario.FUNCIONARIO);
			VeiculoFuncionario veiculoEsperado = new VeiculoFuncionario();
			veiculoEsperado = (VeiculoFuncionario) veiculo;
			veiculoEsperado.setFuncionario(FuncionarioBean
					.obterFuncionarioPeloLogin(usuarioLogado));
			assertEquals(veiculoEsperado, veiculoObtido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}

	}

	@Test
	public void testRegistrarVeiculoCorNaoPreenchida() {
		// Cria um novo veículo
		Veiculo veiculo = new Veiculo();
		veiculo.setPlacas("ABC-1234");
		veiculo.setMarca("Ford");
		veiculo.setModelo("Fiesta");
		// veiculo.setCor("Preta");
		VeiculoBean vBean = new VeiculoBean();
		vBean.setVeiculo(veiculo);
		vBean.setTipoVeiculo("Empresa");
		try {
			vBean.registrarVeiculo();
			fail("Cor deve ser preenchida.");
		} catch (Exception e) {
			// Sucesso. Nada faz.
		}

	}

}
