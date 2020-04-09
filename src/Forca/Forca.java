package Forca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Forca {
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		String[][] palavras = { { "ANIMAL", "CACHORRO", "ARANHA", "ABELHA", "BARATA", "ELEFANTE" },
				{ "OBJETO", "MESA", "GARFO", "ABAJUR", "BACIA", "CABIDE" },
				{ "ALIMENTO", "FIGO", "GENGIBRE", "ABÓBORA", "BRÓCOLIS", "CENOURA" },
				{ "COR", "AMARELO", "VERMELHO", "VERDE", "BRANCO", "AZUL" } };

		String continuar = "S";

		System.out.print("########  #######  ########   ######     ###        ######  ##       #### \n"
				+ "##       ##     ## ##     ## ##    ##   ## ##      ##    ## ##        ##  \n"
				+ "##       ##     ## ##     ## ##        ##   ##     ##       ##        ##  \n"
				+ "######   ##     ## ########  ##       ##     ##    ##       ##        ##  \n"
				+ "##       ##     ## ##   ##   ##       #########    ##       ##        ##  \n"
				+ "##       ##     ## ##    ##  ##    ## ##     ##    ##    ## ##        ##  \n"
				+ "##        #######  ##     ##  ######  ##     ##     ######  ######## #### ");

		System.out.println();
		System.out.println();
		do {
			int categoria = new Random().nextInt(palavras.length);

			int indiceDaPalavra = new Random().nextInt(palavras[categoria].length);
			indiceDaPalavra = (indiceDaPalavra == 0) ? indiceDaPalavra + 1 : indiceDaPalavra;

			int tamanhoPalavra = palavras[categoria][indiceDaPalavra].length();
			int qtdLetrasDescubertas = 0;
			String palavra = palavras[categoria][indiceDaPalavra];
			char[] letrasDescobertas = new char[tamanhoPalavra];
			ArrayList<String> letrasDigitas = new ArrayList<String>();

			for (int i = 0; i < tamanhoPalavra; i++) {
				letrasDescobertas[i] = '_';
			}

			System.out.println("Categoria: " + palavras[categoria][0]);

			char letraUsuario = 0;

			int tentativas = 5;
			do {
				boolean acertou = false;
				boolean digitou = false;

				for (int letra = 0; letra < tamanhoPalavra; letra++) {
					if (letraUsuario == palavra.charAt(letra)) {
						letrasDescobertas[letra] = palavra.charAt(letra);
						qtdLetrasDescubertas++;
						acertou = true;
					}

					System.out.print(" " + letrasDescobertas[letra] + " ");

				}

				if (!acertou) {
					tentativas--;
				}

				System.out.println("");
				System.out.println("Você tem " + tentativas + " tentativas");
				System.out.print("Letras digitadas: ");
				for (String letraDigitada : letrasDigitas) {
					System.out.print(letraDigitada + " ");
				}
				System.out.println("");
				System.out.println("");

				if (tentativas == 0 || qtdLetrasDescubertas == tamanhoPalavra) {
					break;
				}

				System.out.print("Digite uma letra: ");
				letraUsuario = leia.next().toUpperCase().charAt(0);
				do {
					digitou = false;
					for (int letra = 0; letra < letrasDigitas.size(); letra++) {
						if (letrasDigitas.get(letra).equals(String.valueOf(letraUsuario))) {
							digitou = true;
						}
					}

					if (digitou) {
						System.out.print("Você já digitou esssa letra. Digite outra: ");
						letraUsuario = leia.next().toUpperCase().charAt(0);
					}

				} while (digitou);

				letrasDigitas.add(String.valueOf(letraUsuario));

			} while (qtdLetrasDescubertas != tamanhoPalavra && tentativas != 0);

			if (tentativas == 0) {
				System.out.println("Você perdeu e foi enforcado. A palvra era: " + palavra);
			} else {
				System.out.println("Parabêns você acertou a palvra!");
			}

			System.out.print("Deseja continuar jogando?[S/N]: ");
			continuar = leia.next().toUpperCase();
			continuar = continuar.substring(0, 1);

			while (!(continuar.contains("S") || continuar.contains("N"))) {
				System.out.print("Não entendi. Deseja continuar?[S/N]: ");
				continuar = leia.next().toUpperCase();
				continuar = continuar.substring(0, 1);
			}

		} while (continuar.equals("S"));

		System.out.println("Obrigado por jogar!");
		System.out.println("Pontuação final: 100");
	}

}
