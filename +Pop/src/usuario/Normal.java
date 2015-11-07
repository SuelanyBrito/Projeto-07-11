package usuario;

import post.Post;

public class Normal implements TipoUsuario {

	@Override
	public int curtir(Post post) {

		return 10;
	}

	@Override
	public int rejeitar(Post post) {

		return -10;
	}

}
