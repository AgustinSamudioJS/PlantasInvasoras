package juego;
import java.awt.Color;
import java.awt.Image;
import java.util.Scanner;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	// Variables y métodos propios de cada grupo
	String puntaje[][] = new String[2][10];
	Escudo escudo;
	Image winner;
	Image gameOver;
	Image Fondo;
	Boss boss;
	Layka layka;
	Domingo domingo;
	Planta planta1;
	Planta planta2;
	Planta planta3;
	Planta planta4;
	Planta planta5;
	Auto auto;
	Auto auto2;
	Colision manzana1;
	Colision manzana2;
	Colision manzana3;
	Colision manzana4;
	Colision manzana5;
	Colision manzana6;
	Proyectil proyectil;
	double anguloFondo;
	Juego(){
		
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Plantas Invasoras - Grupo 5 - v1", 800, 591);
		// Inicializar lo que haga falta para el juego
		escudo=new Escudo(400,580,20,20);
		boss=new Boss(400,560,40,40);
		layka = new Layka(400, 560,40,40);
		planta1=new Planta(480,575,40,40);
		planta1.setAngulo(Herramientas.radianes(0));
		planta2=new Planta(22,50,40,40);
		planta2.setAngulo(Herramientas.radianes(270));
		planta3=new Planta(266,318,40,40);
		planta3.setAngulo(Herramientas.radianes(270));
		planta4=new Planta(100,16,40,40);
		planta4.setAngulo(Herramientas.radianes(0));
		auto=new Auto(490,300,100,40);
		auto.setAngulo(Herramientas.radianes(90));
		auto2=new Auto(200,280,40,100);
		auto2.setAngulo(Herramientas.radianes(0));
		manzana1=new Colision(173, 170, 180, 133);
		manzana2=new Colision(400, 170, 180, 133);
		manzana3=new Colision(625, 170, 180, 133);
		manzana4=new Colision(173, 430, 180, 133);
		manzana5=new Colision(404, 430, 180, 133);
		manzana6=new Colision(623, 430, 180, 133);
//		proyectil=new Proyectil(100,100,10,20);
		Fondo = Herramientas.cargarImagen("FondoCalleJuego3.png");
		gameOver= Herramientas.cargarImagen("gameover.png");
		winner = Herramientas.cargarImagen("winner.png");
		anguloFondo=0;
		proyectil=new Proyectil(100,100,10,20);
//		Herramientas.cargarSonido("musica2.wav");
//		Herramientas.cargarSonido("muerte.wav");
//		Herramientas.loop("musica2.wav");
		// Inicia el juego!
		this.entorno.iniciar();
	}
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	int puntos=0;
	int nivel=1;
	int muertes=0;
	int cont=0;
	@SuppressWarnings("resource")
	
	public void tick() {
			if(entorno.sePresiono(entorno.TECLA_ENTER)) {
				System.exit(0);
			}
		
			if(layka!=null) {
			//MOVIMIENTOS PERRO 1 (Layka)		
			if (entorno.sePresiono(entorno.TECLA_DERECHA))
				layka.setAngulo(Herramientas.radianes(0));

			if (entorno.sePresiono(entorno.TECLA_IZQUIERDA))
				layka.setAngulo(Herramientas.radianes(180));

			if (entorno.sePresiono(entorno.TECLA_ARRIBA))
				layka.setAngulo(Herramientas.radianes(270));

			if (entorno.sePresiono(entorno.TECLA_ABAJO))
				layka.setAngulo(Herramientas.radianes(90));
			if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) ||
				    entorno.estaPresionada(entorno.TECLA_DERECHA) ||
				    entorno.estaPresionada(entorno.TECLA_ARRIBA) ||
				    entorno.estaPresionada(entorno.TECLA_ABAJO))
				  {
				   layka.moverAdelante();
				   layka.prenderMotor();

				  } else {
				   layka.apagarMotor();
				  }
			// PROYECTILES: AL CONTAR MAS DE 100 TICKS ESTANDO EN PANTALLA, EL PROYECTIL DESAPARECE. ESTE MISMO 
		    // APARECE EN EL X Y EL Y DE LAYKA, Y SE VA MOVIENDO A LA IZQUIERDA O DERECHA, DEPENDIENDO DEL ANGULO 
		    // EN EL QUE MIRE
			
				
		    if (!proyectil.cooldown()) {
		     if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
		     
		      proyectil.setPosicion(layka.x , layka.y);		      
		      proyectil.setAngulo(layka.angulo);
		      proyectil.dibujarse(entorno);
		      proyectil.dibujarCaja(entorno);
		      proyectil.contadorTicks = 0;
		      }
		     } else {
		     proyectil.dibujarse(entorno);
		     proyectil.moverAdelante();
		    }
			
			//COLISION CON LAS CAJAS
			if (manzana1.colisionCaja(33+manzana1.ancho/2, 33+manzana1.alto/2, manzana1.alto, manzana1.ancho, layka.x, layka.y, layka.ancho, layka.alto) 
			|| manzana2.colisionCaja(263+manzana2.ancho/2, 33+manzana2.alto/2, manzana2.alto, manzana2.ancho, layka.x, layka.y, layka.ancho, layka.alto)
			||(manzana1.colisionCaja(488+manzana3.ancho/2, 33+manzana3.alto/2, manzana3.alto, manzana3.ancho, layka.x, layka.y, layka.ancho, layka.alto)
			||manzana4.colisionCaja(33+manzana4.ancho/2, 293+manzana4.alto/2, manzana4.alto, manzana4.ancho, layka.x, layka.y, layka.ancho, layka.alto)
			||manzana5.colisionCaja(263+manzana5.ancho/2, 293+manzana5.alto/2, manzana5.alto, manzana5.ancho, layka.x, layka.y, layka.ancho, layka.alto))
		    ||manzana6.colisionCaja(488+manzana6.ancho/2, 293+manzana6.alto/2, manzana6.alto, manzana6.ancho, layka.x, layka.y, layka.ancho, layka.alto)) {
				layka.empujar();
			}
			//DIBUJOS
			
			anguloFondo = 0;
			entorno.dibujarImagen(Fondo, 400, 295.5, anguloFondo); //FONDO
			planta1.dibujarse(entorno);
			planta1.moverAdelante();
			planta2.dibujarse(entorno);
			planta2.moverAdelante();
			planta3.dibujarse(entorno);
			planta3.moverAdelante();
			planta4.dibujarse(entorno);
			planta4.moverAdelante();
			auto.moverAdelante();
			auto2.moverAdelante();
			auto2.dibujarse(entorno);
			layka.dibujarse(entorno);
			auto.dibujarse(entorno);
			entorno.cambiarFont("Impact", 20, Color.black);
//			entorno.escribirTexto("posicion en x:" + layka.x, 500, 150);
//			entorno.escribirTexto("posicion en y:" + layka.y, 500, 200);
			entorno.cambiarFont("Impact", 20, Color.white);
			entorno.escribirTexto("Points:" + puntos, 8, 20);
			entorno.escribirTexto("Level:"+nivel, 710, 580);
			entorno.escribirTexto("Plants:"+muertes, 8, 580);
			
			
			if (!proyectil.cooldown()) {
				if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
					proyectil.setPosicion(layka.x, layka.y);
					proyectil.setAngulo(layka.angulo);
					proyectil.dibujarse(entorno);
					proyectil.dibujarCaja(entorno);
					proyectil.contadorTicks = 0;
					}
			} else {
					proyectil.dibujarse(entorno);
					proyectil.moverAdelante();
					proyectil.dibujarCaja(entorno);
			}
			//COLISION CON AUTO
			if (auto.colisionCaja(auto.x-3, auto.y-32, auto.alto, auto.ancho, layka.x, layka.y, layka.ancho, layka.alto)
			   ||auto.colisionCaja(auto2.x-3, auto2.y-32, auto2.alto, auto2.ancho, layka.x, layka.y, layka.ancho, layka.alto)) {
				Herramientas.play("muerte.wav");
				layka=null;
				entorno.dibujarImagen(Fondo, 400, 295.5, anguloFondo);
				entorno.dibujarImagen(gameOver, 400, 295.5, anguloFondo,0.8);
			}
			//COLISION CON LA PLANTA
			if (auto.colisionCaja(planta1.x, planta1.y, planta1.alto, planta1.ancho, proyectil.x, proyectil.y, proyectil.ancho, proyectil.alto)) {
				Herramientas.play("muerte.wav");
				planta1=null;
				if (cont==0) {
					planta1=new Planta(310,10,40,40);
					cont=cont+1;
				}
				else {
					planta1=new Planta(80,540,40,40);
					cont=0;
				}
				
				puntos=puntos+5;	
				muertes=muertes+1;
			}
			if (auto.colisionCaja(planta2.x, planta2.y, planta2.alto, planta2.ancho, proyectil.x, proyectil.y, proyectil.ancho, proyectil.alto)) {
				Herramientas.play("muerte.wav");
				planta2=null;
				planta2=new Planta(726,540,40,40);
				puntos=puntos+5;	
				muertes=muertes+1;
			}
			if (auto.colisionCaja(planta3.x, planta3.y, planta3.alto, planta3.ancho, proyectil.x, proyectil.y, proyectil.ancho, proyectil.alto)) {
				Herramientas.play("muerte.wav");
				planta3=null;
				planta3=new Planta(530,580,40,40);
				puntos=puntos+5;	
				muertes=muertes+1;
			}
			if (auto.colisionCaja(planta4.x, planta4.y, planta4.alto, planta4.ancho, proyectil.x, proyectil.y, proyectil.ancho, proyectil.alto)) {
				Herramientas.play("muerte.wav");
				planta4=null;
				planta4=new Planta(166,58,40,40);
				puntos=puntos+5;	
				muertes=muertes+1;
			}
			
			//MOVIMIENTOS PERRO 2
			
			//NIVEL 2
			if(puntos>=20 && puntos <=100) {
				//aumentar velocidad de los autos y plantas
				escudo.dibujarCaja(entorno);
				escudo.dibujarse(entorno);
				nivel=2;
				auto.velocidad=4;
				auto2.velocidad=4;
				planta1.velocidad=3;
				planta2.velocidad=3;
				planta3.velocidad=3;
				planta4.velocidad=3;	
			}
			//NIVEL 3
			if(puntos>=105 && puntos <=150) {
				//aumentar velocidad de los autos y plantas
				nivel=3;
				auto.velocidad=5;
				auto2.velocidad=5;
				planta1.velocidad=4;
				planta2.velocidad=4;
				planta3.velocidad=4;
				planta4.velocidad=4;	
			}
			//NIVEL 4
			if(puntos>=155 && puntos <=300) {
				//aumentar velocidad de los autos y plantas
				escudo.dibujarCaja(entorno);
				escudo.dibujarse(entorno);
				nivel=4;
				auto.velocidad=6;
				auto2.velocidad=6;
				planta1.velocidad=5;
				planta2.velocidad=5;
				planta3.velocidad=5;
				planta4.velocidad=5;	
				boss.dibujarse(entorno);
			}
			//GANAR
			if(puntos>=305) {
				layka=null;
				proyectil=null;
				planta1=null;
				planta2=null;
				planta3=null;
				planta4=null;
				auto=null;
				auto2=null;
				boss=null;
				entorno.dibujarImagen(Fondo, 400, 295.5, anguloFondo);
				entorno.dibujarImagen(winner, 400, 295.5, anguloFondo,0.8);
				entorno.cambiarFont("Impact", 20, Color.white);
				entorno.escribirTexto("PUNTOS:" + puntos, 700, 20);
			}
	
			
		} // TERMINA EL IF NULL
			
			else { 
				Scanner teclado= new Scanner(System.in);
				String PuntosS= String.valueOf(puntos);
				String usuario;
				String respuesta;
				System.out.println("Ingrese el nombre de usuario: ");
				usuario=teclado.next();
				puntaje[0][0]=usuario;
				puntaje[0][1]=PuntosS;
				for(int i = 0; i < puntaje.length; i++){ 
					for(int j = 0; j < puntaje[i].length; j++){
						if (puntaje[i][j]==null) {
							puntaje[i][j]="";
						}
						 
					} 
					System.out.println();	// Imprime salto de línea 
				}
				for(int i = 0; i < puntaje.length; i++){ 
					for(int j = 0; j < puntaje[i].length; j++){
						if (puntaje[i][j]=="") {
							puntaje[i][j]=usuario;
						}
						 
					} 
					System.out.println();	// Imprime salto de línea 
				} 
				
				//MOSTRAR LA MATRIZ
				for(int i = 0; i < puntaje.length; i++){ 
					for(int j = 0; j < puntaje[i].length; j++){ 
						System.out.print(puntaje[i][j] + " ");	// Imprime elemento 
					} 
					System.out.println();	// Imprime salto de línea 
				} 
				System.out.println("¿Quiere seguir jugando?, S:si, para no: ingrese cualquier tecla.");
				respuesta=teclado.next();
				if(respuesta.equalsIgnoreCase("s")) {
					boss=new Boss(400,560,40,40);
					layka = new Layka(400, 560,40,40);
					planta1=new Planta(480,575,40,40);
					planta1.setAngulo(Herramientas.radianes(0));
					planta2=new Planta(22,50,40,40);
					planta2.setAngulo(Herramientas.radianes(270));
					planta3=new Planta(266,318,40,40);
					planta3.setAngulo(Herramientas.radianes(270));
					planta4=new Planta(100,16,40,40);
					planta4.setAngulo(Herramientas.radianes(0));
					auto=new Auto(490,300,100,40);
					auto.setAngulo(Herramientas.radianes(90));
					auto2=new Auto(200,280,40,100);
					auto2.setAngulo(Herramientas.radianes(0));
					proyectil=new Proyectil(-1000,-1000,5,5);
					puntos=0;
					nivel=1;
					muertes=0;
				}
				else {
					System.exit(0);
				}
			}
} //TERMINA EL TICK
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
	
}

