package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import entorno2.Entorno;
import entorno2.Herramientas;
//entorno.dibujarImagen(portal, 780, 540, anguloFondo, 0.17);
public class Portal {
	// Variables de instancia
	int ancho;
	int alto;
	int x;
	int y;
	double angulo;
	Image img1;
	Color myColor = Color.blue;
	Rectangle cajaLayka = new Rectangle(x, y, alto, ancho);

	public Portal(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		img1 = Herramientas.cargarImagen("recursos/portal.gif");
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.17);

	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public void dibujarCaja(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, alto, ancho, 0, myColor);
	}
}