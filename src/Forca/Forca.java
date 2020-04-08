package Forca;

import java.util.Scanner;

public class Forca {
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		boolean gameOver = false;
		int tentativas = 5;
		String[][] palavras = { { "ANIMAL", "CACHORRO", "ARANHA" }, { "OBJETO", "MESA", "GARFO" } };
		int categoria = (int) Math.round((Math.random() * (palavras.length - 1)));

		int indiceDaPalavra;
		do {
			indiceDaPalavra = (int) Math.round((Math.random() * (palavras[categoria].length - 1)));
		} while (indiceDaPalavra == 0);

		int tamanhoPalavra = palavras[categoria][indiceDaPalavra].length();
		int qtdLetrasDescubertas = 0;
		char[] letras = palavras[categoria][indiceDaPalavra].toCharArray();
		String[] letrasDescobertas = new String[tamanhoPalavra];

		for (int i = 0; i < tamanhoPalavra; i++) {
			letrasDescobertas[i] = " _ ";
		}

		System.out.print("=".repeat(5));
		System.out.print(" JOGO DA FORCA CLI - " + palavras[categoria][0] + " ");
		System.out.println("=".repeat(5));

		char letraUsuario = 0;
		do {
			System.out.println("Você tem " + tentativas + " tentativas");

			for (int letra = 0; letra < tamanhoPalavra; letra++) {
				if (letraUsuario == letras[letra]) {
					letrasDescobertas[letra] = " " + letras[letra];
					qtdLetrasDescubertas++;
				}

				System.out.print(letrasDescobertas[letra]);
		
			}
			
			System.out.println("");
			System.out.println("");
			if (qtdLetrasDescubertas != tamanhoPalavra) {
				System.out.print("Digite uma letra: ");
				letraUsuario = leia.next().toUpperCase().charAt(0);
			}

			System.out.println("");
		} while (qtdLetrasDescubertas != tamanhoPalavra);
		if(gameOver) {
			System.out.println("Perdeu");
		}else {
			System.out.println("Venceu");
		}
	}

}
