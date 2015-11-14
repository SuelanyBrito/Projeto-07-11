package usuario;

import post.Post;

public class IconePOP implements TipoUsuario {

	@Override
	public int curtir(Post post) {
		post.adicionaHashtag("#epicwin");
		return 50;

	}

	@Override
	public int rejeitar(Post post) {
		post.adicionaHashtag("#epicfail");
		return -50;

	}

}
