package estudio_tarea_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorAlumnos {

	private static Scanner sc = new Scanner(System.in);

	public Alumno leerAlumno() {

		System.out.print("Nia: ");
		int nia = sc.nextInt();
		sc.nextLine();

		String nombre = solicitarString("Nombre: ");
		String apellidos = solicitarString("Apellido: ");

		char genero = leerGenero();

		LocalDate fechaNacimiento = leerFechaNacimiento();

		String ciclo = solicitarString("Ciclo: ");
		String curso = solicitarString("Curso: ");
		String grupo = solicitarString("Grupo: ");

		Alumno alumno = new Alumno(nia, nombre, apellidos, genero, fechaNacimiento, ciclo, curso, grupo);

		System.out.println(alumno.toString());

		return alumno;

	}

	private String solicitarString(String dato) {
		System.out.print(dato.toUpperCase());
		dato = sc.nextLine().trim().toUpperCase();
		return dato;
	}

	public char leerGenero() {
		char genero;
		while (true) {
			System.out.print("Género (M/F): ");
			genero = sc.nextLine().toUpperCase().charAt(0);
			if (genero == 'M' || genero == 'F') {
				break;
			} else {
				System.out.println("Género inválido. Por favor, ingresa 'M' o 'F'.");
			}
		}
		return genero;
	}

	public LocalDate leerFechaNacimiento() {
		while (true) {
			try {
				System.out.print("Fecha de nacimiento (dd-MM-yyyy): ");
				String fechaStr = sc.nextLine();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				return LocalDate.parse(fechaStr, formato);
			} catch (Exception e) {
				System.out.println("Formato de fecha incorrecto. Intenta de nuevo (dd-MM-yyyy).");
			}
		}
	}

	public List<Alumno> listaAlumnos(int veces) {
		List<Alumno> listaAlumnos = new ArrayList<>();

		for (int i = 1; i <= veces; i++) {
			Alumno alumno = leerAlumno();
			listaAlumnos.add(alumno);
		}

		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno);
		}

		return listaAlumnos;

	}

	public List<Alumno> ordenarPorCriterio(String criterio, List<Alumno> listaAlumnos) {

		switch (criterio) {
		case "nia" -> listaAlumnos.sort((a1, a2) -> Integer.compare(a1.getNia(), a2.getNia()));
		case "nombre" -> listaAlumnos.sort((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
		case "apellidos" -> listaAlumnos.sort((a1, a2) -> a1.getApellidos().compareTo(a2.getApellidos()));
		case "genero" -> listaAlumnos.sort((a1, a2) -> Character.compare(a1.getGenero(), a2.getGenero()));
		case "fechaNacimiento" ->
			listaAlumnos.sort((a1, a2) -> a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento()));

		case "ciclo" -> listaAlumnos.sort((a1, a2) -> a1.getCiclo().compareTo(a2.getCiclo()));
		case "curso" -> listaAlumnos.sort((a1, a2) -> a1.getCurso().compareTo(a2.getCurso()));
		case "grupo" -> listaAlumnos.sort((a1, a2) -> a1.getGrupo().compareTo(a2.getGrupo()));

		default -> throw new IllegalArgumentException("Unexpected value: " + criterio);
		}
		return listaAlumnos;

	}

}
