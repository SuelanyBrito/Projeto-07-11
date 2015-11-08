package usuario;

import post.Post;

public class IconePOP implements TipoUsuario {

	@Override
	public int curtir(Post post) {
		post.getHashtags().put("#epicwin", 1);
		return 50;

	}

	@Override
	public int rejeitar(Post post) {
		post.getHashtags().put("#epicfail", 1);
		return -50;

	}

}
