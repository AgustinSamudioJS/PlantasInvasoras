package juego;

import entorno2.Herramientas;

public class Prueba {
	public static void main(String[] args) {
		String puntaje[][] = new String[11][2];
		puntaje[0][0]="[Usuario]";
		puntaje[0][1]="[Puntos]";
		puntaje[1][0]=" Agustin"+"    ";
		puntaje[1][1]="14";
		Herramientas.ImprimirMatriz(puntaje);

	}

}
