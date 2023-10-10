package modelo;

public class Estudiante {
	private String nombre;
	private String rut;
	private String apellido;
	private int numeroMatricula;
	private Carrera carrera;

    public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumeroMatricula() {
		return this.numeroMatricula;
	}

	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Estudiante(String nombre, String rut, String apellido, int numeroMatricula) {
		super();
	}
}