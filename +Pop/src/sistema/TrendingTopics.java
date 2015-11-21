package sistema;

import java.util.List;

import post.Hashtag;

public class TrendingTopics {
	/*Como usu�rio desejo ver qual o ranking de usu�rios e informa��es mais/menos populares que est�o da rede. 
	 * O sistema deve fornecer algumas informa��es da rede que devem estar dispon�veis para os usu�rios. 
	 * Essas informa��es s�o: o ranking dos 3 usu�rios mais/menos populares, e o ranking das 3 hashtags mais presentes nos posts da rede (trending topics). 
	 * Essas informa��es s�o atualizadas a partir da chamada do m�todo �atualizaRankings� na Fa�ade do projeto. 
	 * Portanto, n�o precisa se preocupar em atualizar esse Ranking de forma din�mica, e sim, apenas na chamada pela Fa�ade.
	OBS: Em casos de empate no ranking de Usu�rios ou no Trending Topics, o crit�rio para desempate � a ordem alfab�tica (decrescente) do e-mail do usu�rio e da hashtag. 
	Portanto se:
	Italo (italo@email.com) e Manoel (abc_manoel@email.com) possuem 900 pops cada,
	o usu�rio com maior ranking ser� aquele cujo e-mail ser� maior considerando a ordem alfab�tica. No caso, Italo > Manoel.
	Se #casa = 3; #familia = 3; ent�o, #familia > #casa.

	Fiquem atentos aos casos com caraceteres mai�scula e min�scula. No caso:
	Se #soulinda = 3; #souQuemSou = 3; ent�o #souQuemSou > #soulinda. Note que o compareTo default de String resulta um resultado contr�rio devido � codifica��o da String.
	*/
	
	List<Hashtag> lista;
	
	public TrendingTopics (){
		
	}

}
