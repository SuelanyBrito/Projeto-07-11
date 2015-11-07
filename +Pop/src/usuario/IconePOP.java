package usuario;

import post.Post;

public class IconePOP implements TipoUsuario {

	@Override
	public int curtir(Post post) {

		return 50;

	}

	@Override
	public int rejeitar(Post post) {

		return -50;

	}

}
