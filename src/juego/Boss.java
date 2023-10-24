package juego;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import entorno.Entorno;
import entorno.Herramientas;

public class Boss {
	int ancho;
	int alto;
	int x;
	int y;
	double angulo;
	Image img1;
	Image img2;
	boolean motor;
	Color myColor= Color.blue;
	Rectangle caja=new Rectangle(x,y,ancho,alto);
	int velocidad = 2;
		public Boss(int x, int y,int ancho,int alto) {
			this.x = x;
			this.y = y;
			this.alto=alto;
			this.ancho=ancho;
		    motor=false; 
			img1 = Herramientas.cargarImagen("Boss.gif");
			img2 = Herramientas.cargarImagen("Boss.gif");
		}
		public void dibujarse(Entorno entorno)
		  {
		   //entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
		  
		   if (motor)
		    entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.2);
		   else
		    entorno.dibujarImagen(img2, this.x, this.y, this.angulo, 0.2);
		  }
}