package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Receta 
{
	private Integer id_receta;
	private String nombre;	
	private Integer dificultad;
	private ArrayList<Ingrediente> ingredientes = new ArrayList();
	private Map<Integer,String> pasos = new HashMap();
	private String categoria;
	private String tiempo;
	private Integer kcal;
	
	//public static final Finder<String,Receta> find = new Finder<>(User.class);
	
	public Receta() {
		super();
	}
	
	public Receta(Integer id_receta, String nombre, Integer dificultad, ArrayList<Ingrediente> ingredientes,
			Map<Integer, String> pasos, String categoria, String tiempo, Integer kcal) {
		super();
		this.id_receta = id_receta;
		this.nombre = nombre;
		this.dificultad = dificultad;
		this.ingredientes = ingredientes;
		this.pasos = pasos;
		this.categoria = categoria;
		this.tiempo = tiempo;
		this.kcal = kcal;
	}

	public Integer getId_receta() {
		return id_receta;
	}

	public void setId_receta(Integer id_receta) {
		this.id_receta = id_receta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDificultad() {
		return dificultad;
	}

	public void setDificultad(Integer dificultad) {
		this.dificultad = dificultad;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Map<Integer, String> getPasos() {
		return pasos;
	}

	public void setPasos(Map<Integer, String> pasos) {
		this.pasos = pasos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getKcal() {
		return kcal;
	}

	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}
	
	public void addIngrediente(Receta receta, Ingrediente ingrediente) {
		receta.getIngredientes().add(ingrediente);
	}
	
	/*public static Receta findByName(String nombre) {
		if(nombre==null) {
			throw new IllegalArgumentException();
		}
	return null;
	}*/
}
