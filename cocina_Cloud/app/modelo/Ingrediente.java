package modelo;

public class Ingrediente 
{
	private Integer id_ingrediente;
	private String nombre_i;
	private Integer cantidad;
		
	public Ingrediente(Integer id_ingrediente, String nombre_i, Integer cantidad) {
		super();
		this.id_ingrediente = id_ingrediente;
		this.nombre_i = nombre_i;
		this.cantidad = cantidad;
	}

	public Integer getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre_i() {
		return nombre_i;
	}

	public void setNombre_i(String nombre_i) {
		this.nombre_i = nombre_i;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
