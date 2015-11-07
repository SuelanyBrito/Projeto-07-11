package post;

public abstract class Midia {

	private String conteudo;

	public Midia(String conteudo) {
		this.conteudo = conteudo;

	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public String toString(){
		return "";
	}

}
