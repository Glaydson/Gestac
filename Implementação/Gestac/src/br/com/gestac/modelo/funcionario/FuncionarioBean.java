package br.com.gestac.modelo.funcionario;

import java.util.ArrayList;

import br.com.gestac.modelo.usuario.Usuario;
import br.com.gestac.modelo.usuario.UsuarioBean;
import br.com.gestac.modelo.veiculo.Veiculo;
import br.com.gestac.persistencia.FuncionarioDAO;

public class FuncionarioBean {

	private static final String BRANCO = "";

	public FuncionarioBean() {
		adicionarFuncionarios();
	}

	public static Funcionario buscarPelaMatricula(int matricula) {

		return FuncionarioDAO.buscarPelaMatricula(matricula);
	}

	public static void adicionarFuncionarios() {

		Funcionario func1 = new Funcionario();
		func1.setCPF("001.002.003-00");
		func1.setDeficiente(false);
		func1.setMatricula(1);
		func1.setNome("João José");
		Usuario usuario1 = UsuarioBean.buscarPeloLogin("usuario3");
		func1.setUsuario(usuario1);
		func1.setVeiculos(new ArrayList<Veiculo>());
		FuncionarioDAO.adicionar(func1);

		Funcionario func2 = new Funcionario();
		func2.setCPF("004.005.006-00");
		func2.setDeficiente(true);
		func2.setMatricula(2);
		func2.setNome("Maria Raimunda");
		Usuario usuario2 = UsuarioBean.buscarPeloLogin("usuario4");
		func2.setUsuario(usuario2);
		func2.setVeiculos(new ArrayList<Veiculo>());
		FuncionarioDAO.adicionar(func2);

	}

	public static Funcionario obterFuncionarioPeloLogin(String login) {
		return FuncionarioDAO.buscarPeloLogin(login);
	}

	public static void adicionarVeiculo(Funcionario func, Veiculo veiculo) {
		FuncionarioDAO.adicionarVeiculo(func, veiculo);

	}
}
