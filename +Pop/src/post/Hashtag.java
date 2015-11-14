package post;

public class Hashtag {

	String nome;
	int qtde;
	
	public Hashtag(String nome){
		this.nome = nome;
		this.qtde = 1;
	}
	
	
	public void aumentaQtde(int qtde) {
		this.qtde += qtde;
	}


	public String getNome() {
		return nome;
	}


	public int getQtde() {
		return qtde;
	}
	
	
}
