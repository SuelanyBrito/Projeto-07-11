package util;

import java.io.Serializable;



import exceptions.DadoInvalidoException;

public class UtilitiesController implements Serializable {

	private static final long serialVersionUID = 1L;

	public UtilitiesUser utilUser;

	public UtilitiesController() {
		utilUser = new UtilitiesUser();

	}
	
	
	// Metodo q verifica dados do cadastrarUsuario
	public void verificacao(String nome, String email, String senha, String data) throws DadoInvalidoException {
			utilUser.isNomeValido(nome);
			utilUser.isSenhaValida(senha);
			utilUser.isDataValida(data);
			utilUser.isEmailValido(email);	
		
	}
	
	
	
	
	
	
	
}
