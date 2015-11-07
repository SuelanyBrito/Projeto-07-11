package post;

public class Imagem extends Midia {

	public Imagem(String conteudo) {
		super(conteudo);

	}
	
	public String toString(){
		return "$arquivo_imagem:"+super.getConteudo();
	}

}
