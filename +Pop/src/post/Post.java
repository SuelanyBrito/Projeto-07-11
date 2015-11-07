package post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Post {
	
	private static final int NUMERO_MAXIMO_DE_CARACTERES = 200;



	private String mensagemInicial;
	private UtilitiesPost utilPost;
	private List<Midia> midia;
	private int like, dislike;
	private LocalDateTime dataCriacao;
	private HashMap<String, Integer> hashtags;
	private String texto;

	private List<String> conteudoDoPost;
	
	public Post(String msg, LocalDateTime data) {
		
		this.mensagemInicial = msg;
		
		this.like = 0;
		this.dislike = 0;

		this.utilPost = new UtilitiesPost();
		this.conteudoDoPost = new ArrayList<String>();
		
		this.midia = new ArrayList<Midia>();
		this.hashtags = new HashMap<String, Integer>();
		this.texto = new String();
		this.texto = utilPost.capturaTexto(msg);
		
		this.utilPost.capturaAudio(this.midia,msg);
		this.utilPost.capturaHashTags(this.hashtags,msg);
		this.utilPost.capturaImagem(this.midia,msg);

		this.dataCriacao = data;
		
		this.utilPost.adicionaConteudo(conteudoDoPost, midia, texto);

	}

	public static int getNumeroMaximoDeCaracteres() {
		return NUMERO_MAXIMO_DE_CARACTERES;
	}

	public int getPopularidade() {
		return like - dislike;
	}

	public List<Midia> getMidia() {
		return midia;
	}

	public List<String> getConteudoDoPost() {
		return conteudoDoPost;
	}
	
	public int getLike() {
		return like;
	}

	public int getDislike() {
		return dislike;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public String getDataEHora() {
		return this.utilPost.DataEhora(this.getDataCriacao()) ;
	}
	
	public String getTexto() {
		return texto;
	}

	public String getMensagem() {
		return this.utilPost.capturaMsg(this.mensagemInicial);
	}
	
	public HashMap<String, Integer> getHashtags() {
		return hashtags;
	}
	
	public String getListaHashtags(){
		String hashtags = "";
		for (String key : this.getHashtags().keySet()) {
			if(hashtags.equals("")){
				hashtags += key;
			} else{
				hashtags += "," + key;
			}
			
		 }
		return hashtags;
	}

	
	public String toString(){
		return this.mensagemInicial + " (" + this.getDataEHora() +")";
	}


}
