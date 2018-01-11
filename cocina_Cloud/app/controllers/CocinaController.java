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

import play.mvc.Controller;

//import modelo.Ingrediente;
//import modelo.Receta;

public class CocinaController extends Controller 
{
	
	ArrayList<Receta> recetas = new ArrayList();  
	
	ArrayList<Ingrediente> ingredientes1 = new ArrayList(); 
	
	Ingrediente i1 = new Ingrediente(1, "patata", 3);
	Ingrediente i2 = new Ingrediente(2, "huevo", 2);
	
	public Result addReceta ()
	{
		//ingredientes1.add(i1);
		//ingredientes1.add(i2);
		Map <Integer, String> pasos = new HashMap();
		pasos.put(1, "cortar patata");
		pasos.put(2, "meterlo a la sarten");
		
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
	    		
	    		Receta r1 = new Receta(1, "tortilla", 2, ingredientes1, pasos, "plato unico", "30 minutos", 500);
	    		
	    		if(recetas.contains(r1)) {
	    			return Results
	    					.status(409, new Error("2", "Nick repetido").toJson());
	    		}
	    		
	    		recetas.add(r1);
	    		
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
}
