package post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import exceptions.MensagemInvalidaException;

public class UtilitiesPost {

	public UtilitiesPost() {

	}

	public LocalDateTime dataPostFormatChange(String data) {

		String[] newDateAndHour = data.split(" ");

		String[] newDate = newDateAndHour[0].split("/");
		String[] newHour = newDateAndHour[1].split(":");

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);

		int hora = Integer.parseInt(newHour[0]);
		int minuto = Integer.parseInt(newHour[1]);
		int segundo = Integer.parseInt(newHour[2]);

		LocalDateTime dateAndHour = LocalDateTime.of(ano, mes, dia, hora, minuto, segundo);

		return dateAndHour;

	}
	
	// Formato da Data em String
	public String DataEhora(LocalDateTime data){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String text = data.format(formatter);
		return text;
	}

	public void verificaPost(String mensagem) throws MensagemInvalidaException {

		if (mensagem == null) {
			throw new MensagemInvalidaException("Campo mensagem nao pode ser nulo");
		}
		if (mensagem.trim().equals("")) {
			throw new MensagemInvalidaException("Campo da mensagem nao pode ser vazio!");
		}

		String mensagemModificada = capturaTexto(mensagem);
		
		if (mensagemModificada.length() > Post.getNumeroMaximoDeCaracteres()) {
			throw new MensagemInvalidaException(
					"Nao eh possivel criar o post. O limite maximo da mensagem sao 200 caracteres.");
		}

	}

	
	public void adicionaConteudo(List<String> conteudo,List<Midia> midia, String msg){
		conteudo.add(msg);
		for (int i = 0; i < midia.size(); i++) {
			conteudo.add(midia.get(i).toString());
		}
	}
	
	
	public void capturaHashTags(HashMap<String, Integer> hashtags, String mensagem) {

		// Nao esta funcionando para este caso:
		// "Nao eh possivel criar o post. As hashtags devem comecar com '#'.
		// Erro na hashtag: 'almoco'."
		// criaPost mensagem="Depois do programa vou almocar com a familia.
		// #familia almoco #paz" data="02/08/2015 11:48:00"

		String[] palavras = mensagem.split(" ");
		for (String palavra : palavras) {
			if (palavra.startsWith("#")) {
				if (hashtags.containsKey(palavra)) {
					for (Entry<String, Integer> entry : hashtags.entrySet()) {
						if (entry.getKey().equals(palavra)) {
							String key = entry.getKey();
							int value = entry.getValue() + 1;
							hashtags.put(key, value);
						}
					}
				} else {
					hashtags.put(palavra, 1);
				}
			}
		}
	}

	public void capturaAudio(List<Midia> conteudo,String mensagem) {

		String[] palavras = mensagem.split("<audio>");

		for (String palavra : palavras) {
			if (palavra.startsWith("musicas")) {
				String[] palavras2 = palavra.split("</audio>");
				for (String palavraModificada : palavras2) {
					if (palavraModificada.startsWith("musicas")) {
						Audio audio = new Audio(palavraModificada);
						conteudo.add(audio);
					}
				}
			}
		}

	}

	public void capturaImagem(List<Midia> conteudo,String mensagem) {

		String[] palavras = mensagem.split("<imagem>");

		for (String palavra : palavras) {
			if (palavra.startsWith("imagens")) {
				String[] palavras2 = palavra.split("</imagem>");
				for (String palavraModificada : palavras2) {
					if (palavraModificada.startsWith("imagens")) {
						Imagem imagem = new Imagem(palavraModificada);
						conteudo.add(imagem);
					}
				}
			}
		}
		
		

	}

	public String capturaTexto(String mensagem) {

		String msgSeparada = "";
		String[] palavras = mensagem.split("\\s*[#]|\\s*[<]");

		int i = 1;
		for (String palavra : palavras) {
			if (i == 1) {
				msgSeparada = palavra;
				i = i + 1;
			}
		}

		return msgSeparada;
	}
	
	
	public String capturaMsg(String mensagem) {

		String msgSeparada = "";
		String[] palavras = mensagem.split("\\s*[#]");

		int i = 1;
		for (String palavra : palavras) {
			if (i == 1) {
				msgSeparada = palavra;
				i = i + 1;
			}
		}

		return msgSeparada;
	}
	
	
}
