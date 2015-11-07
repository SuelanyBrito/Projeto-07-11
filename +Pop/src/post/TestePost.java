package post;

import facade.Facade;

public class TestePost {

	public static void main(String[] args) throws Exception {
		
		Facade facade = new Facade();
		facade.cadastraUsuario("Nazare Tedesco","naza_foguete@hotmail.com","belzinha" ,"17/09/1962","resources/fatima.jpg");
		
		facade.login("naza_foguete@hotmail.com", "belzinha");
		facade.criaPost("Eu nao sou preconceituosa, mais aqui esta cheio de anta nordestina. #anta #separa","01/08/2015 12:00:00");
		facade.criaPost("Esse frio esta mim deixando doida. #alucicrazy #CGDaDepressao" ,"01/08/2015 21:35:00");
		facade.criaPost("Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio> #soulinda #naza" ,"03/08/2015 08:21:00");
		
		System.out.println(facade.getConteudoPost(1, 2));

		//UtilitiesPost util = new UtilitiesPost();

		//util.capturaHashTags("Eu nao sou preconceituosa, mais aqui esta cheio de anta nordestina. #anta #separa");
		//util.capturaAudio(
				//"Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio> #soulinda #naza");

		
		
		//String msg = "O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro #SemPreconceito";
		
		//LocalDateTime data = LocalDateTime.of(2015, 8, 1, 12, 00, 00);
		//Post post = new Post(msg, data);
		
		//System.out.println(post.toString());
		

		//System.out.println(post.getConteudo().toArray());

		//System.out.println(post.getHashtags().toString());

	}

}
