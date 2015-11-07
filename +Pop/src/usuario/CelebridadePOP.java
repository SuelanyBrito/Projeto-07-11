package usuario;

import java.time.LocalDate;

import post.Post;

public class CelebridadePOP implements TipoUsuario {

	private LocalDate dataAtual;

	@Override
	public int curtir(Post post) {

		int popsTotais = 25;

		if (dataAtual.toString().equals(post.getDataCriacao().toString())) {
			popsTotais += 10;
		}

		return popsTotais;
	}

	@Override
	public int rejeitar(Post post) {
		int popsTotais = -25;

		if (dataAtual.toString().equals(post.getDataCriacao().toString())) {
			popsTotais -= 10;
		}

		return popsTotais;
	}

}
