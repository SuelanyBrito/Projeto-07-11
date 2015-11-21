package sistema;

import java.util.List;

import post.Hashtag;

public class TrendingTopics {
	/*Como usuário desejo ver qual o ranking de usuários e informações mais/menos populares que estão da rede. 
	 * O sistema deve fornecer algumas informações da rede que devem estar disponíveis para os usuários. 
	 * Essas informações são: o ranking dos 3 usuários mais/menos populares, e o ranking das 3 hashtags mais presentes nos posts da rede (trending topics). 
	 * Essas informações são atualizadas a partir da chamada do método ‘atualizaRankings’ na Façade do projeto. 
	 * Portanto, não precisa se preocupar em atualizar esse Ranking de forma dinâmica, e sim, apenas na chamada pela Façade.
	OBS: Em casos de empate no ranking de Usuários ou no Trending Topics, o critério para desempate é a ordem alfabética (decrescente) do e-mail do usuário e da hashtag. 
	Portanto se:
	Italo (italo@email.com) e Manoel (abc_manoel@email.com) possuem 900 pops cada,
	o usuário com maior ranking será aquele cujo e-mail será maior considerando a ordem alfabética. No caso, Italo > Manoel.
	Se #casa = 3; #familia = 3; então, #familia > #casa.

	Fiquem atentos aos casos com caraceteres maiúscula e minúscula. No caso:
	Se #soulinda = 3; #souQuemSou = 3; então #souQuemSou > #soulinda. Note que o compareTo default de String resulta um resultado contrário devido à codificação da String.
	*/
	
	List<Hashtag> lista;
	
	public TrendingTopics (){
		
	}

}
