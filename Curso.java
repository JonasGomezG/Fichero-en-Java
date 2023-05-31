
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Curso {

	private ArrayList<Persona> grupoPersonas = new ArrayList<Persona>();

	public Curso() {
		super();
	}

	public ArrayList<Persona> getGrupoPersonas() {
		return grupoPersonas;
	}

	public void setGrupoPersonas(ArrayList<Persona> grupoPersonas) {
		this.grupoPersonas = grupoPersonas;
	}

	@Override
	public String toString() {
		return "Curso [grupoPersonas=" + grupoPersonas + "]";
	}



	FileReader fichero = null;
	BufferedReader lector = null;
	String cadena;{

	try
	{

		fichero = new FileReader("fichero/fichero.txt");
		lector = new BufferedReader(fichero);

		while ((cadena = lector.readLine()) != null) {
			String datos[] = cadena.split(";");
			
			String[] FechaN = datos[1].split("-");
			int ano = Integer.parseInt(FechaN[0]);
			int mes = Integer.parseInt(FechaN[1]);
			int dia = Integer.parseInt(FechaN[2]);
			LocalDate nacimiento = LocalDate.of(ano, mes, dia);

			grupoPersonas.add(new Persona(datos[0], nacimiento, datos[2]));
		}
	}catch(
	FileNotFoundException e)
	{
		System.out.println("No se encuentra el fichero");
		e.printStackTrace();
	}catch(
	IOException r)
	{
		System.out.println("Error de entrada/salida");
		r.printStackTrace();
	}catch(
	Exception t)
	{
		System.out.println("Error inesperado");
		t.printStackTrace();
	}finally
	{
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
}
