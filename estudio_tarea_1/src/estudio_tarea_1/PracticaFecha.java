package estudio_tarea_1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PracticaFecha {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Definimos el formato:
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Solicitamos la fecha STRING:
		System.out.print("Introduce tu fecha de nacimiento (dd-mm-aaaa): ");
		String fechaString = sc.nextLine();

		// Parseamos la fechaString a LocalDate:
		LocalDate fecha = LocalDate.parse(fechaString, formato);
		LocalDate hoy = LocalDate.now();

		// Formateamos de LocalDate a fechaString:
		System.out.println("Hoy es: " + hoy.format(formato));

		// Calculamos los años transcurridos:
		int edad = Period.between(fecha, hoy).getYears();
		System.out.print("Han transcurrido " + edad + " años");
	}
}