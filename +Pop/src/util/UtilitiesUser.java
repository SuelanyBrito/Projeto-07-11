package util;

import java.time.DateTimeException;

import java.time.LocalDate;

import exceptions.CadastroException;
import exceptions.MensagemInvalidaException;

public class UtilitiesUser {

	public UtilitiesUser() {

	}

	public void isDataValida(String data) throws CadastroException {
		
		if (data == null) {
			throw new CadastroException(
					"Data invalida, campo nao pode ser nulo.");
		}
		if (data.length() != 10) {
			throw new CadastroException("Formato de data esta invalida.");
		} 
		
	

	}

	public void isNomeValido(String nome) throws CadastroException {
		if (nome == null) {
			throw new CadastroException(
					"Nome dx usuarix nao pode ser vazio.");
		}
		if (nome.trim().equals("")) {
			throw new CadastroException(
					"Nome dx usuarix nao pode ser vazio.");
		}
		if (!(nome.matches("[A-Za-z?-?\\s]*+"))) {
			throw new CadastroException(
					"Nome so pode conter caracteres alfabeticos");
		}
	}

	public void isSenhaValida(String senha) throws CadastroException {
		if (senha == null) {
			throw new CadastroException("senha nao pode ser nula");
		}
		if (senha.trim().equals("")) {
			throw new CadastroException("senha nao pode ser vazia");
		}
		if (senha.length() < 6) {
			throw new CadastroException(
					"senha nao pode ter tamanho menor que 6");
		}
	}

	public void isMensagemValida(String mensagem) throws Exception {

		if (mensagem == null) {
			throw new MensagemInvalidaException(
					"Mensagem invalida, campo nulo.");
		}
		if (mensagem.trim().equals("")) {
			throw new MensagemInvalidaException(
					"Mensagem invalida, campo vazio.");
		}

	}

	public void isEmailValido(String email) throws CadastroException {
		if (email == null) {
			throw new CadastroException("email nao pode ser nulo");
		}
		if (email.trim().equals("")) {
			throw new CadastroException("email nao pode ser vazio");
		}
		if (!email.contains("@")) {
			throw new CadastroException("Formato de e-mail esta invalido.");
		}
		if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false) {
			throw new CadastroException("Formato de e-mail esta invalido.");
		}

	}

	public void isDataNascimentoValida(String dataNascimento) throws CadastroException{

		if (dataNascimento == null || dataNascimento.trim().equals("")) {
			throw new CadastroException(
					"Data de nascimento nao pode ser vazio");
		}
	}

	public void isFotoValida(String foto) throws CadastroException {

		if (foto == null || foto.equals("")) {
			throw new CadastroException("Foto nao pode ser vazia");
		}
	}

	public LocalDate dataFormatChanges(String data)
			throws CadastroException {

		String[] newDate = data.split("/");

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		
		LocalDate date;
		
		try{
			date = LocalDate.of(ano, mes, dia);
		} catch(DateTimeException e){
			throw new CadastroException("Data nao existe.");
		}
		return date;

	}

}
