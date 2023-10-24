package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Domingo {

	// Variables de instancia
	double x;
	double y;
	double angulo;
	Image img1;
	Image img2;
	boolean motor;
	
	public Domingo(int x, int y) 
	{
		this.x = x;
		this.y = y;
	    motor=false; 
		img1 = Herramientas.cargarImagen("domingo.gif");
		img2 = Herramientas.cargarImagen("domingo.gif");
	}
	
	public void dibujarse(Entorno entorno)
	{
		//entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
	
		if (motor)
			entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.4);
		else
			entorno.dibujarImagen(img2, this.x, this.y, this.angulo, 0.4);
	}

	public void girar(double modificador) 
	{
		this.angulo = this.angulo + modificador;
		if(this.angulo < 0) {
			this.angulo +=2*Math.PI;
		}
        if(this.angulo > 2*Math.PI) {
        	this.angulo -=2*Math.PI;
        }
	}

	public void moverAdelante() {
		this.x += Math.cos(this.angulo)*1;
		this.y += Math.sin(this.angulo)*1;
		if(this.x > 900) {
			this.x=-100;
		}
		if(this.x < -100) {
			this.x=900;
		}
		if(this.y > 650) {
			this.y=-50;
		}
		if(this.y < -50) {
			this.y=650;
		}
	
	}

	public void prenderMotor() {
		// TODO Auto-generated method stub
		this.motor=true;
		}

	public void apagarMotor() {
		// TODO Auto-generated method stub
		this.motor=false;
		
	}
}

