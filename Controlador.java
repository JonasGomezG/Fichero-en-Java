import java.util.Scanner;

public class Controlador {

	public static void main(String[] args){
		
		int opcion;
		int mes;
		int edadMinima;
		int edadMaxima;
		
		Scanner lector = new Scanner(System.in);
		
		Fichero f1 = new Fichero("fichero/fichero.txt");
		
		Curso c1 = new Curso();
		
		f1.setPersonas(c1.getGrupoPersonas());
		
		do {
			System.out.println("Selecciona una opcion:");
			System.out.println("1. Seleccionar por mes");
			System.out.println("2. Ver quien es mayor y quien es menor");
			System.out.println("3. Mostrar por rango de edad");
			System.out.println("4. Mostrar por signo del zodiaco");
			System.out.println("5. Ordenar la lista");
			System.out.println("6. Ver la edad media");
			System.out.println("7. Salir del programa");
			opcion = lector.nextInt();
			lector.nextLine();
			
			switch (opcion) {
			case 1:
				do {
					System.out.println("De que mes quieres ver los alumnos (1 - 12)");
					mes = lector.nextInt();
					lector.nextLine();
				} while (mes > 12 || mes < 1);
				f1.verMes(f1, mes);
				System.out.println(" ");
			break;
			case 2:
				System.out.println(" ");
				f1.verMayorMenor(f1);
				System.out.println(" ");
			break;
			case 3:
				System.out.println("Edad minima para el rango: ");
				edadMinima = lector.nextInt();
				lector.nextLine();
				System.out.println("Edad maxima para el rango: ");
				edadMaxima = lector.nextInt();
				lector.nextLine();
				
				System.out.println("Los alumnos en el rango de edad de " + edadMinima + "-" + edadMaxima + " son:");
				
				f1.rangoEdad(f1,edadMinima, edadMaxima);
				
				System.out.println(" ");
			break;
			case 4:
				System.out.println(" ");
				f1.zodiaco(f1);
				System.out.println(" ");
			break;
			case 5:
				System.out.println(" ");
				f1.ordenarEdad(f1);
				System.out.println(" ");
			break;
			case 6:
				System.out.println(" ");
				f1.edadMedia(f1);
				System.out.println(" ");
			break;
			case 7:
				System.out.println(" ");
				System.out.println("Saliendo del programa...");
				System.out.println("Programa finalizado.");
				System.out.println(" ");
			break;
			default:
				System.out.println(" ");
				System.out.println("Opcion no disponible");
				System.out.println(" ");
			break;
			}
		} while (opcion != 7);
	}
}
