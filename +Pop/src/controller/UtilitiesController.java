package controller;

import exceptions.CadastroException;
import exceptions.LoginException;
import usuario.Usuario;
import util.UtilitiesUser;

public class UtilitiesController {

	public UtilitiesUser utilUser;

	public UtilitiesController() {

		utilUser = new UtilitiesUser();

	}

	// Metodo que verificar se há algum usuario logado
	public void isUsuarioLogado(String msg, Usuario logado)
			throws LoginException {
		if (logado == null) {
			throw new LoginException(msg);
		}
	}

	// Metodo q verifica dados do cadastrarUsuario
	public void verificacao(String nome, String email, String senha, String data)
			throws Exception, CadastroException {

		utilUser.isNomeValido(nome);
		utilUser.isSenhaValida(senha);
		utilUser.isDataValida(data);
		utilUser.isEmailValido(email);
	}

}
