package siststock;

import java.time.LocalDate;

public class Persona {
	protected String apellido;
	protected String nombre;
	protected long dni;
	protected LocalDate fechaNacimiento;

	// CONSTRUCTOR
	public Persona(String apellido, String nombre, long dni, LocalDate fechaNacimiento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	// GETTERS Y SETTERS
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "\nPersona [apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + "]\n";
	}

}
