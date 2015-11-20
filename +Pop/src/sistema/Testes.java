package sistema;

import facade.Facade;

public class Testes {
	
	public static void main(String[] args) throws Exception {
		Facade facade = new Facade();
		facade.iniciaSistema();
		facade.cadastraUsuario("Nazare Tedesco" ,"naza_foguete@hotmail.com" ,"belzinha","17/09/1962");
		facade.cadastraUsuario("fafa" ,"fafa_bernardes@email.com.br" ,"fafa_S2","17/09/1962");
		facade.cadastraUsuario("Madonna","madonna@email.com" ,"iamawesome" ,"16/08/1958","resources/madonna.jpg");
		
		facade.login("naza_foguete@hotmail.com","belzinha");
		facade.criaPost("Eu nao sou preconceituosa, mais aqui esta cheio de anta nordestina. #anta #separa","01/08/2015 12:00:00");
		facade.criaPost("Esse frio esta mim deixando doida. #alucicrazy #CGDaDepressao" ,"01/08/2015 21:35:00");
		facade.criaPost("Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio> #soulinda #naza" ,"03/08/2015 08:21:00");
		facade.logout();

		facade.login("fafa_bernardes@email.com.br","fafa_S2");
		facade.criaPost ("O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro #SemPreconceito" ,"01/08/2015 20:12:00");
		facade.criaPost ("Hoje o sol me acordou. Foi muito cansativo sair da cama pois ainda estava com muito sono. Gostaria ter mais tempo para dormir. Ainda bem que tinha tapioca e cuscuz no cafe da manha para dar energia. #cafe #acorda" ,"02/08/2015 09:30:00");
		facade.logout();

		facade.fechaSistema();	
		
		
		facade.iniciaSistema();
		facade.login( "naza_foguete@hotmail.com" ,"belzinha");
		facade.adicionaAmigo ("fafa_bernardes@email.com.br");

		facade.logout();

		facade.login("fafa_bernardes@email.com.br","fafa_S2");

		facade.rejeitaAmizade ("naza_foguete@hotmail.com");
		
		facade.adicionaAmigo("madonna@email.com");

		facade.logout();

		facade.login ("madonna@email.com","iamawesome");
		facade.aceitaAmizade ("fafa_bernardes@email.com.br");

		facade.curtirPost ("fafa_bernardes@email.com.br",1);
		facade.logout();
		facade.login("naza_foguete@hotmail.com" ,"belzinha");
		facade.criaPost ("Tem gente que se acha! #SouMaisEu" ,"07/08/2015 16:10:00");
		facade.logout();

		facade.login("madonna@email.com" ,"iamawesome");
		facade.removeAmigo ("fafa_bernardes@email.com.br");
		facade.logout();

		facade.login("fafa_bernardes@email.com.br" ,"fafa_S2");

		facade.logout();

		facade.fechaSistema();
		
		facade.adicionaAmigo("fafa_bernardes@email.com.br");
		facade.logout();

		facade.login("fafa_bernardes@email.com.br","fafa_S2");
		System.out.println(facade.getNotificacoes());
		System.out.println(facade.getNextNotificacao());
		
	}
}
