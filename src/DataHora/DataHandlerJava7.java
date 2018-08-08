package DataHora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHandlerJava7 {

	private GregorianCalendar gc;
	private Date data;
	private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	public DataHandlerJava7(String data) {

		try {

			this.gc = new GregorianCalendar();
			this.gc.setTime(formatador.parse(data));

		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public DataHandlerJava7(Date data) {

		this.gc = new GregorianCalendar();
		this.gc.setTime(data);
		this.data = data;
	}

	public Date getData(){
		return this.data;
	}

	public void adicionarDias(int quantidade){
		adicionar(quantidade, Calendar.DAY_OF_MONTH);
	}

	public void adicionarMeses(int quantidade){
		adicionar(quantidade, Calendar.MONTH);
	}

	public void adicionarAnos(int quantidade){
		adicionar(quantidade, Calendar.YEAR);
	}

	private void adicionar(int quantidade, int tipoCampo){
		gc.add(tipoCampo, quantidade);
		data = gc.getTime();
	}        

	public int getMinutos(){
		return getCampo(Calendar.MINUTE);
	}

	public int getHoras(){
		return getCampo(Calendar.HOUR);
	}

	private int getCampo(int tipoCampo){
		return gc.get(tipoCampo);
	}

	public Integer comparar(String data){
		try {
			return comparar(formatador.parse(data));
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}        

	public int comparar(Date data){
		
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		
		return gc.compareTo(c);
	}        

	public String getAsString(){
		return formatador.format(data);
	}
	
	public static void main(String[] args){
		
		/*SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		Date date = null;
		try {
			date = formatador.parse("02/12/2018 12:02:22");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(Calendar.DAY_OF_MONTH, 5);
		System.out.println(gc.get(Calendar.DAY_OF_MONTH));
		
	}
}
