import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

/*
 * Programar com um temporizador, indicando quantos minutos e segundos deve funcionar ok
 * Pausar pelo usu�rio ok
 * Reiniciar pelo usu�rio ok
 * Desligar pelo usu�rio
 * S� ligar se porta estiver fechada ok
 * S� pode abrir se estiver deslidado ok
 * Atualiza o tempo enquanto estiver em funcionamento ok
 * Sinalizar a passagem de tempo ok
 */

class MicroondasTest {

	@Test
	public void microondas() {
		Microondas micro = new Microondas();
		assertNotNull(micro);
	}
	
	
	@Test
	public void reiniciarTempo() { //reiniciar pelo usu�rio
		Microondas micro = new Microondas();
		micro.ligado();
		micro.pausar();
		assertTrue(micro.getReinicair());
	}
	
	@Test
	public void ligarPortaFechada() { //s� ligar se porta estiver fechada
		Microondas micro = new Microondas();
		micro.ligado();
		micro.abrir();
		assertTrue(micro.getPausar());
	}
	
	
	@Test
	public void abrirPortaLigado() { //s� pode abrir se estiver deslidado
		Microondas micro = new Microondas();
		micro.abrir();
		micro.ligado();
		assertTrue(micro.getPausar());
	}
	
	@Test
	public void abrirPorta() { 
		Microondas micro = new Microondas();
		micro.abrir();
		assertFalse(micro.getFechado());
	}
	
	@Test
	public void testTempo() { // sinalizar a passagem de tempo e atualiza enquanto estiver rodando
		
		Microondas micro = new Microondas();
		Scanner sc = new Scanner(System.in);
		System.out.println("Time de: "); //quantos segundos deve funcionar
		int time = sc.nextInt();
		
		micro.setTempo(time);
		assertEquals(micro.getMinuto(), time / 100);
		assertEquals(micro.getSegundo(), time % 100);
		
		sc.close();
	}

}
