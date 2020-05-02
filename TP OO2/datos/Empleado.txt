package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import datos.Persona;

public class Empleado extends Persona {
	private long idEmpleado;
	private float sueldoBasico;
	private LocalTime horarioTrabajoE;
	private LocalTime horarioTrabajoS;
	private boolean gerente;
	private Local local;

	public Empleado() {
	}

	public Empleado(long dni, String apellido, String nombre, LocalDate fechaNacimiento, int idEmpleado,
			float sueldoBasico, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS, boolean gerente, Local local) {
		super(dni, apellido, nombre, fechaNacimiento);
		this.sueldoBasico = sueldoBasico;
		this.horarioTrabajoE = horarioTrabajoE;
		this.horarioTrabajoS = horarioTrabajoS;
		this.gerente = gerente;
		this.local = local;
	}

	public long getId() {
		return idEmpleado;
	}

	protected void setId(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public float getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico) {
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

	public boolean isGerente() {
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

	public String toString() {
		return "EMPLEADO-dni:" + getDni() + "  nombre:" + getNombre() + "   apellido:" + getApellido()
				+ "   fechaNacimiento:" + getFechaNacimiento().getDayOfMonth() + "/"
				+ getFechaNacimiento().getMonthValue() + "/" + getFechaNacimiento().getYear() + " sueldoBasico:" +
				sueldoBasico + " horarioTrabajoE:" + horarioTrabajoE + " horarioTrabajoS:" + horarioTrabajoS + 
				" gerente: " + gerente +"  local:" + local.getIdLocal();
	}

}
