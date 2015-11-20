package sistema;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {

		args = new String[] { "facade.Facade", "diretorio_testes/usecase_1.txt", "diretorio_testes/usecase_2.txt",
				"diretorio_testes/usecase_3.txt", "diretorio_testes/usecase_4.txt", "diretorio_testes/usecase_5.txt",
				"diretorio_testes/usecase_6.txt", "diretorio_testes/usecase_7.txt", "diretorio_testes/usecase_8.txt",
				"diretorio_testes/usecase_9.txt", "diretorio_testes/usecase_10.txt" };

		EasyAccept.main(args);

	}
}
