package siststock;

import java.time.LocalDate;

public class Cliente extends Persona {
	private String email;

	//CONSTRUCTOR
	public Cliente(String apellido, String nombre, long dni, LocalDate fechaNacimiento, String email) {
		super(apellido, nombre, dni, fechaNacimiento);
		this.email = email;
	}

	//GETTERS Y SETTERS
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString()+"\nCliente [email=" + email + "]";
	}
	

}
