package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingOfUsers {

	List<Usuario> usuarios;
	
	public RankingOfUsers() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void adicionaUsuario(){
		ObjectInputStream in;
		Usuario usuario;
		
		try {
			in = new ObjectInputStream(new FileInputStream(new File("Usuarios_Cadastrados/usuarios.txt")));
			do {
				usuario = (Usuario) in.readObject();
				if (this.usuarios.contains(usuario) == false){
					this.usuarios.add(usuario);
				}
				
				
			} while (usuario != null);
			in.close();

		}catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void adicionaUsuario(Usuario usuario){
		if (this.usuarios.contains(usuario) == false){
			this.usuarios.add(usuario);
		}
	}
	
	
	public void organizaUsuario(){
		Collections.sort(this.usuarios);
	}
	
	public void atualizaRanking(){
		organizaUsuario();
		String ranking;
		
		
		
		
	}
}


