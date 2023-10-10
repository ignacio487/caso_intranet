package modelo;

public class Carrera {
	private String nombre;
	private int semestres;
	private String codigo;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSemestres() {
		return this.semestres;
	}

	public void setSemestres(int semestres) {
		this.semestres = semestres;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Carrera(String nombre, String semestres, int codigo) {
		super();
	}
}