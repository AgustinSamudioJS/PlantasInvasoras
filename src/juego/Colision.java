package juego;
import java.awt.Color;
import entorno2.Entorno;
import java.awt.Rectangle;

public class Colision {
	int x;
	int y;
	int ancho;
	int alto;
	Color myColor= Color.blue;
	Rectangle caja=new Rectangle(x,y,ancho,alto);
	Colision(int x,int y,int ancho, int alto){
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
	}
	
	public boolean colisionCaja(int x1, int y1, int ancho1, int alto1, double x2, double y2, int ancho2, int alto2) {
		if(x1>x2+ancho2 || y1>y2+alto2 || x2>x1+ancho1 || y2>y1+alto1) {	
			return false;
		}
		else {	
			return true;
		}
	}
	public void dibujarCaja(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, alto, ancho, 0, myColor);
	}

}
