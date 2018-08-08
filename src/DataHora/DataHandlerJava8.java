package DataHora;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class DataHandlerJava8{

	public static void main(String[] args) {

		//Manipulação de datas e horas
		Instant agora = Instant.now();
		System.out.println("Instante agora: " + agora.toString());
		
		Instant inicio = Instant.now();
		rodaAlgoritmo();
		Instant fim = Instant.now();
		 
		Duration duracao = Duration.between(inicio, fim);
		long duracaoEmMilissegundos = duracao.toMillis();
		System.out.println("\nDuracão de um loop de 999999999: ");
		System.out.println(duracao);
		System.out.println(duracaoEmMilissegundos + "ms");
		
		LocalDate hoje = LocalDate.now();
		System.out.println("\nHoje: " + hoje);
		
		LocalDate homemNoEspaco = LocalDate.of(1961, Month.APRIL, 12);
		LocalDate homemNaLua = LocalDate.of(1969, Month.MAY, 25);
		 
		Period periodo = Period.between(homemNoEspaco, homemNaLua);
		
		System.out.println("\nPeriodo entre o homem no espaço e na lua: "); 
		System.out.printf("%s anos, %s mês e %s dias", 
		  periodo.getYears() , periodo.getMonths(), periodo.getDays());
		
		System.out.println("\nHora atual: ");
		LocalTime horarioDeEntrada = LocalTime.now();
		System.out.println(horarioDeEntrada);
		
		System.out.println("\nData e Hora da aberura da copa 2014: ");
		LocalDateTime aberturaDaCopa = LocalDateTime.of(2014, Month.JUNE, 12, 17, 0);
		System.out.println(aberturaDaCopa);
		//=============================================================================================//
		
		//Fuso Horario
		ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
		System.out.println("\nFuso horário de SP: " + fusoHorarioDeSaoPaulo);
		
		LocalDateTime dataSemFusoHorario = LocalDateTime.of(2014, Month.APRIL, 4, 22, 30);
		System.out.println("\nData sem fuso horario: " + dataSemFusoHorario);
		
		ZonedDateTime dataComFusoHorario = ZonedDateTime.of(dataSemFusoHorario,fusoHorarioDeSaoPaulo);
		System.out.println("\nData om fuso horario: " + dataComFusoHorario);
		//============================================================================================//
		
		//Representar datas
		MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
		YearMonth copaDoMundo2014 = YearMonth.of(2014, Month.JUNE);
		System.out.println("\ndia do Natal: " + natal);
		System.out.println("\nmes da copa do muno de 2014: " + copaDoMundo2014);
		//===========================================================================================//
		
		//Formatação de datas
		LocalDate hj = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("\nHoje é: " + hoje.format(formatador));
		
		LocalDateTime ag = LocalDateTime.now();
		formatador = DateTimeFormatter
		  .ofLocalizedDateTime(FormatStyle.SHORT)
		  .withLocale(new Locale("pt", "br"));
		String dataHora = ag.format(formatador);
		System.out.println("\nData e hora de hoje: " + dataHora);
		//==========================================================================================//
		
		//Calculando datas
		MonthDay natal1 = MonthDay.of(Month.JULY, 25);
		LocalDate natalDesseAno = natal1.atYear(Year.now().getValue());
		long diasAteONatal = LocalDate.now().until(natalDesseAno, ChronoUnit.DAYS);
		System.out.println("\nFalta " + diasAteONatal + " para o natal.");
		
		TemporalAdjuster ajustadorParaProximaSexta = TemporalAdjusters.next(DayOfWeek.FRIDAY);
		LocalDate proximaSexta = LocalDate.now().with(ajustadorParaProximaSexta);
		System.out.println("\nPróxima sexta-feira: " + proximaSexta);
	}

	private static void rodaAlgoritmo() {

		for(int i=0; i < 999999999; i++) {
			int n = i;
		}
		
	}

}
