import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.transform.Source;

public class Fichero {

	private String ruta;
	private ArrayList<Persona> Personas = new ArrayList<Persona>();

	public Fichero(String ruta) {
		super();
		this.ruta = ruta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public ArrayList<Persona> getPersonas() {
		return Personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		Personas = personas;
	}

	@Override
	public String toString() {
		return "Fichero [ruta=" + ruta + ", Personas=" + Personas + "]";
	}

	public void leerFichero() {
		
		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		try {
			
			fichero = new FileReader(ruta);
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				System.out.println(cadena.toString());
			}
			
			System.out.println(Personas.toString());

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("finally")
	public ArrayList<String> devolverFichero() {

		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;
		ArrayList<String> contenido = new ArrayList<String>();

		try {
			fichero = new FileReader(ruta);
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				contenido.add(cadena);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			} finally {
				return contenido;
			}

		}

	}

	public void escribirFichero(ArrayList<String> datos) {
		FileWriter guardar = null;

		try {
			guardar = new FileWriter(ruta, true);// true = append

			for (String dato : datos) {
				guardar.write(dato + (char) 13);
			}
			// for(int i=0;i<datos.length;i++) {}

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void escribirFichero(Fichero datos) {
		FileWriter guardar = null;
		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		try {
			guardar = new FileWriter(ruta, true);// true = append
			fichero = new FileReader(datos.getRuta());
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				guardar.write(cadena + (char) 13);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();

			}

		}

	}

	public void escribirFichero(String dato) {
		FileWriter guardar = null;

		try {
			guardar = new FileWriter(ruta, true);// true = append
			guardar.write(dato + (char) 13);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	
	public void verMes(Fichero fichero, int mes) {
		try {
			System.out.println("Las personas que nacieron en el mes: " + mes);
			for(Persona elemento: fichero.getPersonas()) {
				if(elemento.getNacimiento().getMonthValue() == mes) {
					System.out.println(elemento.getNombre());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verMayorMenor(Fichero fichero) {
		
		LocalDateTime ahora = LocalDateTime.now();
		int mayor = (int) ChronoUnit.DAYS.between(fichero.getPersonas().get(0).getNacimiento(), ahora);
		int menor = (int) ChronoUnit.DAYS.between(fichero.getPersonas().get(1).getNacimiento(), ahora);
		
		try {

			for(int i = 0; i < fichero.getPersonas().size(); i++) {
				if(ChronoUnit.DAYS.between(fichero.getPersonas().get(i).getNacimiento(), ahora) > mayor) {
					mayor = (int) ChronoUnit.DAYS.between(fichero.getPersonas().get(i).getNacimiento(), ahora);
				}
				if(ChronoUnit.DAYS.between(fichero.getPersonas().get(i).getNacimiento(), ahora) < menor) {
					menor = (int) ChronoUnit.DAYS.between(fichero.getPersonas().get(i).getNacimiento(), ahora);
				}
			}
			for(Persona elemento: fichero.getPersonas()) {
				if(mayor == ChronoUnit.DAYS.between(elemento.getNacimiento(), ahora)) {
					System.out.println("El mayor es: " + elemento.getNombre());
				}
				if(menor == ChronoUnit.DAYS.between(elemento.getNacimiento(), ahora)) {
					System.out.println("El menor es: " + elemento.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rangoEdad(Fichero fichero, int edadMinima, int edadMaxima) {
		
		edadMaxima = edadMaxima * 365;
		edadMinima = edadMinima * 365;
		LocalDateTime ahora = LocalDateTime.now();
		
		try {

			for(Persona elemento: fichero.getPersonas()) {
				if(ChronoUnit.DAYS.between(elemento.getNacimiento(), ahora) > edadMinima && ChronoUnit.DAYS.between(elemento.getNacimiento(), ahora) < edadMaxima) {
					System.out.println(elemento.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void zodiaco(Fichero fichero) {
		
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		
		LocalDate fecha = LocalDate.of(2000, 1, 1);
		
		try {
			for(Persona elemento: fichero.getPersonas()) {
				listaPersonas.add(elemento);
			}
			
			for(int i = 0; i < listaPersonas.size(); i++) {
				LocalDate nacimiento = LocalDate.of(2000, listaPersonas.get(i).getNacimiento().getMonthValue(), listaPersonas.get(i).getNacimiento().getDayOfMonth());
				listaPersonas.get(i).setNacimiento(nacimiento);
			}
			
			LocalDate InicioCapricornio = fecha.minusDays(8);
			LocalDate finalCapricornio = fecha.plusDays(20);
			LocalDate inicioAcuario = fecha.plusDays(21);
			LocalDate finalAcuario = fecha.plusDays(50);
			LocalDate inicioPiscis = fecha.plusDays(51);
			LocalDate finalPiscis = fecha.plusDays(81);
			LocalDate inicioAries = fecha.plusDays(82);
			LocalDate finalAries = fecha.plusDays(112);
			LocalDate inicioTauro = fecha.plusDays(113);
			LocalDate finaTauro = fecha.plusDays(143);
			LocalDate inicioGeminis = fecha.plusDays(144);
			LocalDate finaGeminis = fecha.plusDays(174);
			LocalDate inicioCancer = fecha.plusDays(175);
			LocalDate finaCancer = fecha.plusDays(205);
			LocalDate inicioLeo = fecha.plusDays(206);
			LocalDate finaLeo = fecha.plusDays(236);
			LocalDate inicioVirgo = fecha.plusDays(237);
			LocalDate finaVirgo = fecha.plusDays(267);
			LocalDate inicioLibra = fecha.plusDays(268);
			LocalDate finaLibra = fecha.plusDays(298);
			LocalDate inicioEscorpio = fecha.plusDays(299);
			LocalDate finaEscorpio = fecha.plusDays(329);
			LocalDate inicioSagitario = fecha.plusDays(330);
			LocalDate finaSagitario = fecha.plusDays(360);
			
			ArrayList<String> Capricornio = new ArrayList<String>();
			ArrayList<String> Acuario = new ArrayList<String>();
			ArrayList<String> Piscis = new ArrayList<String>();
			ArrayList<String> Aries = new ArrayList<String>();
			ArrayList<String> Tauro = new ArrayList<String>();
			ArrayList<String> Geminis = new ArrayList<String>();
			ArrayList<String> Cancer = new ArrayList<String>();
			ArrayList<String> Leo = new ArrayList<String>();
			ArrayList<String> Virgo = new ArrayList<String>();
			ArrayList<String> Libra = new ArrayList<String>();
			ArrayList<String> Escorpio = new ArrayList<String>();
			ArrayList<String> Sagitario = new ArrayList<String>();
			
			for(int i = 0; i < listaPersonas.size(); i++) {
				
				if(listaPersonas.get(i).getNacimiento().isAfter(InicioCapricornio) && listaPersonas.get(i).getNacimiento().isBefore(finalCapricornio)) {
					Capricornio.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioAcuario) && listaPersonas.get(i).getNacimiento().isBefore(finalAcuario)) {
					Acuario.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioPiscis) && listaPersonas.get(i).getNacimiento().isBefore(finalPiscis)) {
					Piscis.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioAries) && listaPersonas.get(i).getNacimiento().isBefore(finalAries)) {
					Aries.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioTauro) && listaPersonas.get(i).getNacimiento().isBefore(finaTauro)) {
					Tauro.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioGeminis) && listaPersonas.get(i).getNacimiento().isBefore(finaGeminis)) {
					Geminis.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioCancer) && listaPersonas.get(i).getNacimiento().isBefore(finaCancer)) {
					Cancer.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioLeo) && listaPersonas.get(i).getNacimiento().isBefore(finaLeo)) {
					Leo.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioVirgo) && listaPersonas.get(i).getNacimiento().isBefore(finaVirgo)) {
					Virgo.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioLibra) && listaPersonas.get(i).getNacimiento().isBefore(finaLibra)) {
					Libra.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioEscorpio) && listaPersonas.get(i).getNacimiento().isBefore(finaEscorpio)) {
					Escorpio.add(listaPersonas.get(i).getNombre());
				}
				if(listaPersonas.get(i).getNacimiento().isAfter(inicioSagitario) && listaPersonas.get(i).getNacimiento().isBefore(finaSagitario)) {
					Sagitario.add(listaPersonas.get(i).getNombre());
				}
				
			}
			System.out.println("Capricornio: ");
			System.out.println(Capricornio.toString());
			System.out.println("Acuario: ");
			System.out.println(Acuario.toString());
			System.out.println("Piscis: ");
			System.out.println(Piscis.toString());
			System.out.println("Aries: ");
			System.out.println(Aries.toString());
			System.out.println("Tauro: ");
			System.out.println(Tauro.toString());
			System.out.println("Geminis: ");
			System.out.println(Geminis.toString());
			System.out.println("Cancer: ");
			System.out.println(Cancer.toString());
			System.out.println("Leo: ");
			System.out.println(Leo.toString());
			System.out.println("Virgo: ");
			System.out.println(Virgo.toString());
			System.out.println("Libra: ");
			System.out.println(Libra.toString());
			System.out.println("Escorpio: ");
			System.out.println(Escorpio.toString());
			System.out.println("Sagitario: ");
			System.out.println(Sagitario.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void ordenarEdad(Fichero fichero) {
		
		ArrayList<LocalDate> fechas = new ArrayList<LocalDate>();
		ArrayList<String> ordenacion =  new ArrayList<String>();
		
		try {
			for(int i = 0; i < fichero.getPersonas().size(); i++) {
				fechas.add(fichero.getPersonas().get(i).getNacimiento());
			}
			
			fechas.sort(null);
			
			for(int i = 0; i < fichero.getPersonas().size(); i++) {
				for(int j = 0; j < fichero.getPersonas().size(); j++) {
					if(fechas.get(i) == fichero.getPersonas().get(j).getNacimiento()) {
						ordenacion.add((i + 1) + ": " + fichero.getPersonas().get(j).getNombre());
					}
				}
			}
			System.out.println("El orden de mayor a menor es: ");
			for(int i = 0; i < fichero.getPersonas().size(); i++) {
				System.out.println(ordenacion.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void edadMedia(Fichero fichero) {
		double media;
		int suma = 0;
		
		try {
			for(int i = 0; i < fichero.getPersonas().size(); i++) {
				suma = (int) (suma + (ChronoUnit.YEARS.between(fichero.getPersonas().get(i).getNacimiento(), LocalDate.now())));		
			}
			
			media = suma / fichero.getPersonas().size();
			
			System.out.println("La edad media de la clase es de: " + media + " anos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

}
















