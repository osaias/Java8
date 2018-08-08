package futebol;

public class Partida {

	private Time[] times = new Time[2];
	private String placar;
	private String vencedor;
	
	public Partida(Time t1, Time t2) {
		this.times[0] = t1;
		this.times[1] = t2;
	}
	
	public Time[] getTimes() {
		return this.times;
	}
	
	public String getTime1() {
		return this.times[0].getNome();
	}
	
	public String getTime2() {
		return this.times[1].getNome();
	}
}
