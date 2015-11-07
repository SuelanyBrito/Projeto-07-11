package post;

public class Audio extends Midia {

	public Audio(String conteudo) {
		super(conteudo);

	}

	public String toString(){
		return "$arquivo_audio:"+super.getConteudo();
	}
}
