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

		char continuar = 'S';
		int pontuacao = 0;
		System.out.print("########  #######  ########   ######     ###        ######  ##       ####   ---------    \n"
				+ "##       ##     ## ##     ## ##    ##   ## ##      ##    ## ##        ##    |      \\O/  \n"
				+ "##       ##     ## ##     ## ##        ##   ##     ##       ##        ##    |       |   \n"
				+ "######   ##     ## ########  ##       ##     ##    ##       ##        ##    |       |   \n"
				+ "##       ##     ## ##   ##   ##       #########    ##       ##        ##    |      / \\ \n"
				+ "##       ##     ## ##    ##  ##    ## ##     ##    ##    ## ##        ##    |            \n"
				+ "##        #######  ##     ##  ######  ##     ##     ######  ######## ####   =====        \n");

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

			// Troca as letras por underlines
			for (int i = 0; i < tamanhoPalavra; i++) {
				letrasDescobertas[i] = '_';
			}

			char letraUsuario = 0;
			int tentativas = 7;

			do {

				boolean acertou = false;
				boolean digitou = false;

				for (int letra = 0; letra < tamanhoPalavra; letra++) {
					// Verifica se a letra existe na palavra
					if (letraUsuario == palavra.charAt(letra)) {
						letrasDescobertas[letra] = palavra.charAt(letra); // Troca o underline pela letra
						qtdLetrasDescubertas++;
						acertou = true;
					}

					System.out.print(" " + letrasDescobertas[letra] + " ");

				}

				if (!acertou && letraUsuario != 0) {
					tentativas--;
				}

				System.out.println("");
				System.out.println("");
				System.out.println("Categoria: " + palavras[categoria][0]);
				System.out.println("Você tem " + tentativas + " tentativas.");
				System.out.println("Pontuação: " + pontuacao);

				System.out.print("Letras digitadas: ");
				for (String letraDigitada : letrasDigitas) {
					System.out.print(letraDigitada + " ");
				}

				System.out.println("");
				System.out.println("");

				if (qtdLetrasDescubertas == tamanhoPalavra || tentativas == 0) {
					break;
				}

				System.out.print("Digite uma letra: ");
				letraUsuario = leia.next().toUpperCase().charAt(0);
				do {
					digitou = false;
					for (String letra : letrasDigitas) {
						if (letra.equals(String.valueOf(letraUsuario))) {
							digitou = true;
							break;
						}
					}

					if (digitou) {
						System.out.print("Você já digitou essa letra. Digite outra: ");
						letraUsuario = leia.next().toUpperCase().charAt(0);
					}

				} while (digitou);

				System.out.println("");

				letrasDigitas.add(String.valueOf(letraUsuario));

			} while (qtdLetrasDescubertas != tamanhoPalavra && tentativas != 0);

			if (tentativas == 0) {
				pontuacao -= tamanhoPalavra * 2;
				System.out.println("Você perdeu e foi enforcado. A palvra era '" + palavra + "'.");
				System.out.println("Você perdeu " + (tamanhoPalavra * 2) + " pontos.");
			} else {
				pontuacao += tamanhoPalavra * 2;
				System.out.println("Parabêns você acertou a palvra!");
				System.out.println("Você ganhou " + (tamanhoPalavra * 2) + " pontos.");
			}

			System.out.println("");
			System.out.print("Deseja continuar jogando?[S/N]: ");
			continuar = leia.next().toUpperCase().charAt(0);

			while (!(continuar == 'S' || continuar == 'N')) {
				System.out.print("Não entendi. Deseja continuar?[S/N]: ");
				continuar = leia.next().toUpperCase().charAt(0);
			}

		} while (continuar == 'S');

		System.out.println("");

		System.out.println("Pontuação final: " + pontuacao);
	}

}
