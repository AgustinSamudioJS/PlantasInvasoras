package juego;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import entorno2.Entorno;
import entorno2.Herramientas;

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
	int velocidad = 10;
		public Boss(int x, int y,int ancho,int alto) {
			this.x = x;
			this.y = y;
			this.alto=alto;
			this.ancho=ancho;
		    motor=false; 
			img1 = Herramientas.cargarImagen("recursos/Boss.gif");
			img2 = Herramientas.cargarImagen("recursos/Boss.gif");
		}
		public void dibujarse(Entorno entorno)
		  {
		   //entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
		  
		   if (motor)
		    entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.25);
		   else
		    entorno.dibujarImagen(img2, this.x, this.y, this.angulo, 0.25);
		  }
		
		public void girar(double modificador) {
			this.angulo = this.angulo + modificador;
			if (this.angulo < 0) {
				this.angulo += 2 * Math.PI;
			}
			if (this.angulo > 2 * Math.PI) {
				this.angulo -= 2 * Math.PI;
			}

		}

		public void moverAdelante() {
			this.x += Math.cos(this.angulo) * velocidad;
			this.y += Math.sin(this.angulo) * velocidad;

			if (this.x < 20) {
				this.angulo = Herramientas.radianes(0);
			}
			if (this.x > 780) {
				this.angulo = Herramientas.radianes(180);
			}
			if (this.y < 15) {
				this.angulo = Herramientas.radianes(90);
			}
			if (this.y > 580) {
				this.angulo = Herramientas.radianes(270);
			}

		}

		public void dibujarCaja(Entorno entorno) {
			entorno.dibujarRectangulo(x, y, alto, ancho, 0, myColor);
		}

		public void prenderMotor() {
			// TODO Auto-generated method stub
			this.motor = true;
		}

		public void apagarMotor() {
			// TODO Auto-generated method stub
			this.motor = false;

		}
		public boolean colisionConLayka(int x2,int y2, int ancho2, int alto2) {
			if (x2-3>this.x+this.ancho || y2-32>this.y+this.alto || this.x>x2+ancho2 || this.y>y2+alto2) {
				return false;
			}
			else {
				return true;
			}
		}
}