package post;

import java.io.Serializable;

public class Imagem extends Midia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Imagem(String conteudo) {
		super(conteudo);

	}
	
	public String toString(){
		return "$arquivo_imagem:"+super.getConteudo();
	}

}
