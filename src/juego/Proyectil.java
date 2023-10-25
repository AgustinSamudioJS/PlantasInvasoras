package juego;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import entorno2.Entorno;
import entorno2.Herramientas;
public class Proyectil {
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
 int contadorTicks = 0;
 double velocidad = 3.5;
 
  
  public Proyectil(int x, int y,int ancho,int alto) {
   this.x = x;
   this.y = y;
   this.alto=alto;
   this.ancho=ancho;
//   this.angulo=angulo;
   motor=false; 
   img1 = Herramientas.cargarImagen("BolaFuegoAzul.gif");
   img2 = Herramientas.cargarImagen("BolaFuegoAzul.gif");
  }
  
  public void dibujarse(Entorno entorno)
  {
   //entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
  
   if (motor)
    entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.17);
   else
    entorno.dibujarImagen(img2, this.x, this.y, this.angulo, 0.17);
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
  this.x += Math.cos(this.angulo) * velocidad;
  this.y += Math.sin(this.angulo) * velocidad;
 }

  public void setPosicion(int x,int y){
   this.x = x;
   this.y = y;
  }

  public boolean cooldown(){
   if (contadorTicks > 300){
    return false;
   }
   contadorTicks += 1;
   return true;
  }

  public void anguloProyectil(){
   if (this.angulo == 0 || this.angulo == 180) ;
  }

  public void setAngulo(double angulo) {
   this.angulo = angulo;
  }
  public void dibujarCaja(Entorno entorno) {
   entorno.dibujarRectangulo(x, y, alto, ancho, 0, myColor);
  }

  public boolean colisionCaja(int x1, int y1, int ancho1, int alto1, double x2, double y2, int ancho2, int alto2) {
   if(x1>x2+ancho2  ||y1>y2+alto2 || x2>x1+ancho1 || y2>y1+alto1) { 
    return false;
   }
   else { 
    return true;
   }
 }
}