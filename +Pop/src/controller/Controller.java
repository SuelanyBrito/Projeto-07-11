package controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exceptions.AtualizacaoException;
import exceptions.LoginException;
import post.Post;
import post.UtilitiesPost;
import usuario.Usuario;
import util.UtilitiesUser;

public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, Usuario> usuarios;

	private Usuario logado;

	private UtilitiesUser utilUser;
	private UtilitiesPost utilPost;
	private UtilitiesController utilController;

	public Controller() {
		this.usuarios = new HashMap<String, Usuario>();
		utilUser = new UtilitiesUser();
		utilController = new UtilitiesController();
		utilPost = new UtilitiesPost();

	}

	/**
	 * Inicia Sistema
	 */
	public void iniciaSistema() {

	}

	/**
	 * Fecha Sistema
	 * 
	 * @throws Exception
	 */
	public void fechaSistema() throws LoginException {
		if (this.logado != null) {
			throw new LoginException("Nao foi possivel fechar o sistema. Um usuarix ainda esta logadx.");
		}
	}

	public void cadastrarUsuario(String nome, String email, String senha, String data, String foto) throws Exception {

		utilController.verificacao(nome, email, senha, data);
		utilUser.isFotoValida(foto);

		if (!usuarios.containsKey(email)) {
			usuarios.put(email, new Usuario(nome, email, senha, utilUser.dataFormatChanges(data), foto));

		} else {
			throw new Exception("usuario existente");
		}
	}

	public void cadastrarUsuario(String nome, String email, String senha, String data) throws Exception {

		utilController.verificacao(nome, email, senha, data);
		this.cadastrarUsuario(nome, email, senha, data, "resources/default.jpg");

	}

	public void login(String email, String senha) throws Exception {
		Usuario user = pesquisarUsuario(email);

		if (this.logado != null) {
			throw new LoginException("Um usuarix ja esta logadx: " + this.logado.getNome() + ".");
		} else if (user == null) {
			throw new LoginException("Um usuarix com email " + email + " nao esta cadastradx.");
		} else {
			if (user.getSenha().equals(senha)) {
				this.logado = user;
			} else {
				throw new LoginException("Senha invalida.");
			}
		}
	}

	public void logout() throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel realizar logout.");
		} else {
			this.logado = null;
		}

	}

	// Adiciona Amigo
	public void adicionaAmigo(String email) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel adicionar um amigo.");
		} else {
			int qtdeDePedidos = this.logado.getPedidosDeAmizade().size();

			if (qtdeDePedidos == 0) {
				solicitaAmizade(email);
			} else {
				for (int i = 0; i < qtdeDePedidos; i++) {
					if (this.logado.getPedidosDeAmizade().get(i).equals(email)) {
						Usuario amigo = pesquisarUsuario(email);
						this.logado.adicionaAmigo(amigo);
						amigo.adicionaAmigo(this.logado);
					} else if (qtdeDePedidos - 1 == i
							&& this.logado.getPedidosDeAmizade().get(i).equals(email) == false) {
						solicitaAmizade(email);
					}
				}
			}
		}
	}

	private void solicitaAmizade(String email) throws Exception {
		Usuario usuario = pesquisarUsuario(email);
		if (usuario == null) {
			throw new Exception("O usuario " + email + " nao esta cadastrado no +pop.");
		}

		logado.getNotificacoes().adicionaNotificacao(this.logado.getNome() + " quer sua amizade.");

		usuario.adicionaPedidoDeAmizade(this.logado.getEmail());
	}

	// Remove Amigo
	public void removeAmigo(String email) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel adicionar um amigo.");
		} else {
			for (int i = 0; i < this.logado.getAmigos().size(); i++) {
				Usuario amigo = this.logado.getAmigos().get(i);
				if (this.logado.getAmigos().get(i).getEmail().equals(email)) {
					this.logado.removeAmigo(amigo);
					amigo.removeAmigo(this.logado);
					amigo.getNotificacoes().adicionaNotificacao(this.logado.getNome() + " removeu a sua amizade.");
				}
			}
		}
	}

	// Aceita Amizade
	public void aceitaAmizade(String email) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel aceitar amizade.");
		} else {
			int qtdeDePedidos = this.logado.getPedidosDeAmizade().size();
			Usuario usuario = pesquisarUsuario(email);

			if (qtdeDePedidos == 0 && usuario != null) {
				throw new Exception(usuario.getNome() + " nao lhe enviou solicitacoes de amizade.");

			} else if (usuario == null) {
				throw new Exception("O usuario " + email + " nao esta cadastrado no +pop.");

			} else {
				for (int i = 0; i < qtdeDePedidos; i++) {
					if (this.logado.getPedidosDeAmizade().get(i).equals(email)) {
						this.logado.adicionaAmigo(usuario);
						usuario.adicionaAmigo(this.logado);

					} else if (i == qtdeDePedidos - 1
							&& this.logado.getPedidosDeAmizade().get(i).equals(email) == false) {
						throw new Exception(usuario.getNome() + " nao lhe enviou solicitacoes de amizade.");
					}
				}
			}
		}
	}

	// Rejeita Amizade
	public void rejeitaAmizade(String email) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel rejeita amizade.");
		} else {
			int qtdeDePedidos = this.logado.getPedidosDeAmizade().size();
			Usuario usuario = pesquisarUsuario(email);

			if (qtdeDePedidos == 0 && usuario != null) {
				throw new Exception(usuario.getNome() + " nao lhe enviou solicitacoes de amizade.");

			} else if (usuario == null) {
				throw new Exception("O usuario " + email + " nao esta cadastrado no +pop.");

			} else {
				for (int i = 0; i < qtdeDePedidos; i++) {
					if (this.logado.getPedidosDeAmizade().get(i).equals(email)) {
						this.logado.rejeitaAmizade(email);
						usuario.getNotificacoes().adicionaNotificacao(this.logado.getNome() + " rejeitou sua amizade.");
					} else if (i == qtdeDePedidos - 1
							&& this.logado.getPedidosDeAmizade().get(i).equals(email) == false) {
						throw new Exception(usuario.getNome() + " nao lhe enviou solicitacoes de amizade.");
					}
				}
			}
		}
	}

	// Post
	public void criaPost(String mensagem, String dataEHora) throws Exception {

		utilPost.verificaPost(mensagem);

		if (this.logado == null) {
			throw new LoginException("Nao eh possivel criar um post.");
		}
		
		LocalDateTime dataEHoraModificada = this.utilPost.dataPostFormatChange(dataEHora);
		
		Post post = new Post(mensagem, dataEHoraModificada);
		
		this.logado.adicionarPostagem(post);

	}

	public void adicionaPops(int pops) {

		logado.setPops(pops);

	}

	public void curtirPost(String email, int pops) {
		
	//	this.logado.curtir(post);

	}

	// Atualiza Perfil
	public void atualizaPerfil(String atributo, String valor) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel atualizar um perfil.");
		} else {

			try {

				if (atributo.equals("Nome")) {
					this.logado.setNome(valor);
				} else if (atributo.equals("E-mail")) {
					this.utilUser.isEmailValido(valor);
					this.usuarios.remove(this.logado.getEmail(), this.logado);
					this.logado.setEmail(valor);
					this.usuarios.put(valor, this.logado);
				} else if (atributo.equals("Senha")) {
					throw new Exception("Eh necessario digitar velha senha");
				} else if (atributo.equals("Foto")) {
					this.utilUser.isFotoValida(valor);
					this.logado.setImagem(valor);
				} else if (atributo.equals("Data de Nascimento")) {
					this.utilUser.isDataNascimentoValida(valor);
					this.logado.setDataNascimento(utilUser.dataFormatChanges(valor));
				} else {
					throw new Exception("Atributo invalido.");
				}

			} catch (AtualizacaoException e) {

				e.printStackTrace();
				this.utilUser.isNomeValido(valor);

			}

		}
	}

	public void atualizaPerfil(String atributo, String valor, String velhaSenha) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel atualizar um perfil.");
		} else {
			if (atributo.equals("Senha")) {
				if (this.logado.getSenha().equals(velhaSenha)) {
					this.utilUser.isSenhaValida(valor);
					this.logado.setSenha(valor);
				} else {
					throw new AtualizacaoException("A senha fornecida esta incorreta.");
				}
			}
		}
	}

	private Usuario pesquisarUsuario(String email) {
		if (usuarios.containsKey(email)) {
			return usuarios.get(email);
		}
		return null;
	}

	public void removeUsuario(String email) throws Exception {
		if (this.usuarios.containsKey(email)) {
			this.usuarios.remove(email);
		} else {
			throw new Exception("Email inexistente");
		}
	}

	// Getters
	public Collection<Usuario> getListaUsuarios() {
		return usuarios.values();
	}

	public Usuario getLogado() {
		return this.logado;
	}

	public int getNotificacoes() {
		return this.logado.getNotificacoes().getNotificacoes().size();
	}

	public int getQtdAmigos() {
		return this.logado.getAmigos().size();
	}

	public String getNextNotificacao() throws Exception {
		if (getNotificacoes() == 0) {
			throw new Exception("Nao ha mais notificacoes.");
		} else {
			return this.logado.getNotificacoes().getNextNotificacao();
		}
	}

	public String getNome(String email) {
		if (pesquisarUsuario(email) == null) {
			return "O usuario com email " + email + " nao esta cadastrado.";
		} else {
			return this.usuarios.get(email).getNome();
		}
	}

	public String getInfoUsuario(String atributo, String emailUsuario) throws Exception {
		Usuario user = pesquisarUsuario(emailUsuario);
		if (user == null) {
			throw new Exception("Um usuarix com email " + emailUsuario + " nao esta cadastradx.");
		} else {
			if (atributo.equals("Nome")) {
				return user.getNome();
			} else if (atributo.equals("E-mail")) {
				return user.getEmail();
			} else if (atributo.equals("Senha")) {
				throw new Exception("A senha dx usuarix eh protegida.");
			} else if (atributo.equals("Foto")) {
				return user.getImagem();
			} else if (atributo.equals("Data de Nascimento")) {
				return user.getDataNascimento().toString();
			} else {
				throw new Exception("Atributo invalido.");
			}
		}
	}

	public String getInfoUsuario(String atributo) throws Exception {
		if (this.logado == null) {
			throw new LoginException("Nao eh possivel verificar informacoes do usuario.");
		} else {
			if (atributo.equals("Nome")) {
				return this.logado.getNome();
			} else if (atributo.equals("E-mail")) {
				return this.logado.getEmail();
			} else if (atributo.equals("Senha")) {
				throw new Exception("A senha dx usuarix eh protegida.");
			} else if (atributo.equals("Foto")) {
				return this.logado.getImagem();
			} else if (atributo.equals("Data de Nascimento")) {
				return this.logado.getDataNascimento().toString();
			} else {
				throw new Exception("Atributo invalido.");
			}
		}

	}
	
	
	public String getPost(String atributo, int post) throws Exception {
		Post postagem = this.logado.getPost().get(post);
		
		if (atributo.equals("Mensagem")){
			return postagem.getMensagem();
		} else if (atributo.equals("Data")){
			return postagem.getDataEHora();
		} else if(atributo.equals("Hashtags")){
			return postagem.getListaHashtags();
		}
		throw new Exception("Atributo invalido.");
	}
	
	public String getPost(int post){
		 return this.logado.getPost().get(post).toString();
	}
	
	public String getConteudoPost(int indice, int post) throws Exception{
		Post postagem = this.logado.getPost().get(post);
		if(indice >= postagem.getConteudoDoPost().size()){
			throw new Exception("Item #"+indice+" nao existe nesse post, ele possui apenas "+ postagem.getConteudoDoPost().size()+" itens distintos.");
		} else if(indice < 0){
			throw new Exception("Requisicao invalida. O indice deve ser maior ou igual a zero.");
		}
		return postagem.getConteudoDoPost().get(indice);
	}
	
	

}