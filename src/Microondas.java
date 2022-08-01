import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Microondas {

	private int minuto;
	private int segundo;
	private boolean pausar;
	private boolean fechado;

	public Microondas() { 
		this.minuto = 0;
		this.segundo = 0;
		this.pausar = true;
		this.fechado = true;
	}
	
	
	public boolean getPausar() {
		return this.pausar;
	}

	public Object[] pausar() {
		if (this.pausar == true) {
			this.zerarTemp();
		}
		this.pausar = true;
		return null;
	}

	public boolean getReinicair() {
		return (this.minuto + this.segundo) == 0;
	}


	public void ligado() {
		if (this.fechado == false)
			return;
		if (minuto != 0 || segundo != 0) {
			this.pausar = false;
		}
	}
	

	private void zerarTemp() {
		this.minuto = 0;
		this.segundo = 0;
	}
	
	
	public void abrir() {
		this.fechado = false;
		this.pausar = true;
		
	}


	public int getMinuto() {
		return minuto;
	}


	public int getSegundo() {
		return segundo;
	}


	public boolean getFechado() {
		return this.fechado;
	}
	
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}


	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}


	public void setPausar(boolean pausar) {
		this.pausar = pausar;
	}


	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}

	
	
	public int setTempo(int tempo) {
		if (tempo < 0)
			return 0;
		this.minuto = tempo / 100;
		this.segundo = tempo % 100;
		return 1;
	}

	public static void main(String[] args) {
		
		Microondas micro = new Microondas();
		Scanner sc = new Scanner(System.in);
		System.out.println("Time de:");
		
		int t = sc.nextInt();
		
		micro.setTempo(t);
		micro.ligado();
		
		
		Duration deltaTime = Duration.ZERO;
		Instant beginTime = Instant.now();
		
		while (true) {
			deltaTime = Duration.between(beginTime, Instant.now());
			if (deltaTime.getSeconds() > 1) {
				micro.contagem();
				beginTime = Instant.now();
			}
			
			sc.close();
		}
		
	}


	private void contagem() {

		if (this.getPausar())
			return;
		this.segundo--;
		if (this.segundo == 0) {
			if (this.minuto > 0) {
				this.minuto--;
				this.segundo = 60;
			} else {
				this.pausar();
			}
		}
		System.out.print("--------------------------\n");
		
		System.out.printf("|%d:%d|\n" ,  this.minuto, this.segundo);
		
		if (this.getPausar()) {
			
			System.out.print("--------------------------\n");
			System.out.printf("||Fim! ABRA A PORTA! ||\n");
		}
		
		}


	}
	
