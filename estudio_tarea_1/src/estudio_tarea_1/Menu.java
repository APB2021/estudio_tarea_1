package estudio_tarea_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static Scanner sc = new Scanner(System.in);

	int opcion = -1;

	public void mostrarMenu() {

		GestorAlumnos gestor = new GestorAlumnos();
		List<Alumno> listaAlumnos = new ArrayList<>();

		do {
			System.out.print("""
					1. Leer alumnos
					2. Añadir alumno
					3. Mostrar ordenados los alumnos por NIA
					4. Mostrar ordenados los alumnos por criterio elegido
					0. Salir
					""");

			System.out.print("Elija una opción:");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 0 -> System.out.println("Saliendo");
			// 1. Leer 5 alumnos:
			// El método addAll() de la lista agrega todos los elementos de otra colección a
			// la lista principal.
			case 1 -> listaAlumnos.addAll(gestor.listaAlumnos(3));
			// 2.Añadir alumno
			case 2 -> {
				Alumno alumno = gestor.leerAlumno();
				listaAlumnos.add(alumno);
			}
			// 3. Ordenar por NIA:
			case 3 -> {
				listaAlumnos.sort((a1, a2) -> Integer.compare(a1.getNia(), a2.getNia()));
				listaAlumnos.forEach(System.out::println);
			}
			// 4. Ordenar por criterio elegido:
			case 4 -> {

				int criterio = -1;
				System.out.println("""
						Indique su criterio de ordenacion:
						1. Nia
						2. Nombre
						3. Apellidos
						4. Género
						5. Fecha de Nacimiento
						6. Ciclo
						7. Curso
						8. Grupo
						""");
				criterio = sc.nextInt();
				sc.nextLine();

				switch (criterio) {
				case 1 -> {
					gestor.ordenarPorCriterio("nia", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}
				case 2 -> {
					gestor.ordenarPorCriterio("nombre", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}
				case 3 -> {
					gestor.ordenarPorCriterio("apellidos", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}
				case 4 -> {
					gestor.ordenarPorCriterio("genero", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}
				case 5 -> {
					gestor.ordenarPorCriterio("fechaNacimiento", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}
				case 6 -> {
					gestor.ordenarPorCriterio("ciclo", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}

				case 7 -> {
					gestor.ordenarPorCriterio("curso", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}
				case 8 -> {
					gestor.ordenarPorCriterio("grupo", listaAlumnos);
					listaAlumnos.forEach(System.out::println);
				}

				default -> throw new IllegalArgumentException("Unexpected value: " + criterio);
				}
			}

			default -> throw new IllegalArgumentException("opcion incorrecta: " + opcion);
			}

		} while (opcion != 0);

	}

}
