package siststock;

import java.time.LocalDate;
import java.time.LocalTime;

public class Empleado extends Persona{
	private int id;
	private float sueldoBasico;
	private LocalTime horarioTrabajoE;
	private LocalTime horarioTrabajoS;
	private boolean gerente;
	private Local local;

	//CONSTRUCTOR
	public Empleado(String apellido, String nombre, long dni, LocalDate fechaNacimiento, int id,
			float sueldoBasico, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS, boolean gerente, Local local) {
		super(apellido, nombre, dni, fechaNacimiento);
		this.id = id;
		this.sueldoBasico = sueldoBasico;
		this.horarioTrabajoE = horarioTrabajoE;
		this.horarioTrabajoS = horarioTrabajoS;
		this.gerente = gerente;
		this.local = local;
	}

	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float getSueldoBasico() {
		return sueldoBasico;
	}
	
	public void setSueldoBasico (float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public LocalTime getHorarioTrabajoE() {
		return horarioTrabajoE;
	}

	public void setHorarioTrabajoE(LocalTime horarioTrabajoE) {
		this.horarioTrabajoE = horarioTrabajoE;
	}

	public LocalTime getHorarioTrabajoS() {
		return horarioTrabajoS;
	}

	public void setHorarioTrabajoS(LocalTime horarioTrabajoS) {
		this.horarioTrabajoS = horarioTrabajoS;
	}
	
	public boolean getGerente() {
		return gerente;
	}
	
	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return super.toString() +"Empleado [id=" + id + ", sueldoBasico=" + sueldoBasico + ", horarioTrabajoE=" + horarioTrabajoE
				+ ", horarioTrabajoS=" + horarioTrabajoS + ", gerente=" + gerente + ", local=" + local + "]";
	}

}
