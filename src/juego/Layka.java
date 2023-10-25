package juego;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import entorno2.Entorno;
import entorno2.Herramientas;

public class Layka {
	// Variables de instancia
	int ancho;
	int alto;
	int x;
	int y;
	double angulo;
	Image img1;
	Image img2;
	boolean motor;
	int velocidad = 2;
	Color myColor= Color.blue;
	Rectangle cajaLayka=new Rectangle(x,y,alto,ancho);
	public Layka(int x, int y,int alto,int ancho) 
	{
		this.x = x;
		this.y = y;
		this.ancho=ancho;
		this.alto=alto;
	    motor=false; 
		img1 = Herramientas.cargarImagen("Dug.gif");
		img2 = Herramientas.cargarImagen("Dug.gif");
				
	}
	
	public void dibujarse(Entorno entorno)
	{
		//entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
		entorno.cambiarFont("Impact", 20, Color.white);
		entorno.escribirTexto("Layka", this.x-27, this.y-40);
		
		if (motor)
			entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.2);
		else
			entorno.dibujarImagen(img2, this.x, this.y, this.angulo, 0.2);
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
		this.x += Math.cos(this.angulo)*velocidad;
		this.y += Math.sin(this.angulo)*velocidad;
		
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
	public void empujar() {
		this.x += Math.cos(this.angulo) * -velocidad;
		this.y += Math.sin(this.angulo) * -velocidad;
	}
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public void prenderMotor() {
		// TODO Auto-generated method stub
		this.motor=true;
		}

	public void apagarMotor() {
		// TODO Auto-generated method stub
		this.motor=false;
		
	}
	public void dibujarCaja(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, alto, ancho, 0, myColor);
	}
}
