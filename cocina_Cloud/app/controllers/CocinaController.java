package controllers;

import play.mvc.Result;
import play.mvc.Results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;

//import modelo.Ingrediente;
//import modelo.Receta;

public class CocinaController extends Controller 
{
	
	ArrayList<Receta> recetas = new ArrayList();  
	
	
	
	public Result addRecetaSucio ()
	{
		//ingredientes1.add(i1);
		//ingredientes1.add(i2);
		Map <Integer, String> pasos = new HashMap();
		pasos.put(1, "cortar patata");
		pasos.put(2, "meterlo a la sarten");
		
		Map <Integer, String> pasos2 = new HashMap();
		pasos2.put(1, "Vertir tomate sobre la masa");
		pasos2.put(2, "Espolvorear el queso rallado");
		pasos2.put(3, "Agragar ingredientes deseados");
		pasos2.put(4, "Meter en el hono a 220º");
		
		
		ArrayList<Ingrediente> ingredientes1 = new ArrayList(); 		
		Ingrediente i1 = new Ingrediente(1, "patata", 3);
		Ingrediente i2 = new Ingrediente(2, "huevo", 2);
		ingredientes1.add(i1);
		ingredientes1.add(i2);
		
		ArrayList<Ingrediente> ingredientes2 = new ArrayList(); 		
		Ingrediente i3 = new Ingrediente(1, "tomate", 3);
		Ingrediente i4 = new Ingrediente(2, "queso", 2);
		Ingrediente i5 = new Ingrediente(3, "oregano", 2);
		Ingrediente i6 = new Ingrediente(4, "masa", 2);
		ingredientes2.add(i3);
		ingredientes2.add(i4);
		ingredientes2.add(i5);
		ingredientes2.add(i6);		
		
		//return Results.created();
		

	    		/*if(!request().hasBody()) {
	    			return Results.badRequest("Falta cuerpo");  //revisar
	    		}
	    		JsonNode json = request().body().asJson();
	    		String nick = json.get("nick").asText();
	    		if(nick == null) {
	    			
	    			return Results.badRequest(new Error("1", "Nick requerido").toJson());
	    		}
	    		Integer edad = json.get("edad").asInt();
	    		if(edad == 0) {    			
	    			return Results.badRequest(new Error("1", "Edad requerida").toJson());
	    		}*/
	    		
	    		Receta r1 = new Receta(1, "tortilla", 2, ingredientes1, pasos, "primer plato", "30 minutos", 500);
	    		Receta r2 = new Receta(2, "pizza", 1, ingredientes2, pasos2, "plato unico", "15 minutos", 1200);
	    		
	    		if(recetas.contains(r1)) {
	    			return Results
	    					.status(409, new Error("2", "Nick repetido").toJson());
	    		}
	    		
	    		recetas.add(r1);
	    		recetas.add(r2);
	    		
	    		return Results.created();  //codigo 201 -> exito, se ha creado	    		
	    
	}
	
	
	
	public Result retrieveReceta(String nombre) {
		
		Receta r = new Receta();
		for (Receta receta : recetas) {
			if(receta.getNombre().equals(nombre)) {
				r = receta;
				
				//return ok(Json.toJson(u));
				//return ok("al menos llega");
				
				return ok(views.xml.receta.render(r));
			}
		}
		return ok("No hace inserccion");
		//return Results.notFound();
	}
	
	public Result retrieveRecetas() {
		if(request().accepts("application/xml")) {
			return ok(views.xml.recetas.render(this.recetas));
		}else if(request().accepts("application/json")) {
			return ok(Json.toJson(this.recetas));
		}else {
			return status(415);
		}
	}
	
	public Result retrieveRecetasPorDificultad(Integer dificultad) {
		
		Integer kcal = 1200;
		ArrayList<Receta> recetasPedidas = new ArrayList();
		
		if(dificultad<1 && dificultad>5) {
			return Results
					.status(400, new Error("3", "La dificultad abarca del 1 al 5").toJson());
		}
		
		for (Receta receta : recetas) {//&& receta.getKcal() == kcal
			if(receta.getDificultad()==dificultad ) {
				recetasPedidas.add(receta);
			}			
		}
		if(recetasPedidas.isEmpty()) {
			return Results.noContent();
		} else {
			if(request().accepts("application/xml")) {
				return ok(views.xml.recetas.render(recetasPedidas));
			}else if(request().accepts("application/json")) {
				return ok(Json.toJson(recetasPedidas));
			}else {
				return status(415);
			}
		}
	}
	
	public Result retrieveRecetasPorCategoria(String categoria) {
		return ok();
	}
	
	public Result retrieveRecetasPorIngrediente(String ingrediente) {
		return ok();
	}
}
