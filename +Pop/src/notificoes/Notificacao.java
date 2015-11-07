package notificoes;

import java.util.ArrayList;
import java.util.List;

public class Notificacao {

	private List<String> notificacoes;

	public Notificacao() {
		
		notificacoes = new ArrayList<>();

	}

	public List<String> getNotificacoes() {
		return notificacoes;
	}

	public void adicionaNotificacao(String mensagem) {
		this.notificacoes.add(mensagem);
	}

	public String getNextNotificacao() {
		String notificacao = this.notificacoes.get(0);
		this.notificacoes.remove(0);
		return notificacao;
	}

}
