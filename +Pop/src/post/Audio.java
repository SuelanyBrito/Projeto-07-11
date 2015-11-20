package post;

import java.io.Serializable;

public class Audio extends Midia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Audio(String conteudo) {
		super(conteudo);

	}

	public String toString(){
		return "$arquivo_audio:"+super.getConteudo();
	}
}
