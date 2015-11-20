package sistema;

import facade.Facade;

public class TesteArquivos {
	public static void main(String[] args) throws Exception {
		Facade facade = new Facade();
		
		//iniciaSistema e fechaSistema serao usados para carregar/armazenar os dados do sistema nos arquivos de dados.
		facade.iniciaSistema();

		
		//Cadastro de Usuarios
		//String id1 = facade.cadastraUsuario("Fatima Bernardes","fatima@email.com.br","will_S2","17/09/1962","resources/fatima.jpg");
		//String id2 = facade.cadastraUsuario("Madonna","madonna@email.com" ,"iamawesome" ,"16/08/1958","resources/madonna.jpg");
		//String id3 = facade.cadastraUsuario("Jo Soares","jo@uol.com.br" ,"!soares!" ,"16/01/1938"); 
		

		
		//Login de Usuarios		

		facade.login("fatima@email.com.br","will_S2");
	
		facade.logout();
		

		//facade.removeUsuario(id3);

		facade.fechaSistema();
		
		facade.iniciaSistema();
		
		facade.login("fatima@email.com.br","will_S2");
		facade.logout();
		
		facade.login("jo@uol.com.br" ,"!soares!");
		
	}
}
