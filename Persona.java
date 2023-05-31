import java.time.LocalDate;
import java.time.Month;

public class Persona {
	
	private String nombre;
	private LocalDate nacimiento;
	private String curso;
	
	public Persona(String nombre, LocalDate nacimiento, String curso) {
		super();
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", nacimiento=" + nacimiento + ", curso=" + curso + "]";
	}

	public void setNacimiento(int i, int mes, int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}
	
	

}
