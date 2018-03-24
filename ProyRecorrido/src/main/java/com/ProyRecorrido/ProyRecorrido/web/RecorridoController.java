package com.ProyRecorrido.ProyRecorrido.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyRecorrido.ProyRecorrido.model.Recorrido;

@Controller
public class RecorridoController {
	
	
	@GetMapping("/Recorrido")
	public String initCreationForm(Model model) {
		model.addAttribute("recorrido", new Recorrido());
		return "recorridoFrm";
	}
	
	@PostMapping("/resultado")
	public String submitForm(@ModelAttribute Recorrido recorrido) {
		
		String mensaje="";
		String nombre = recorrido.getNombre();
		String marca= recorrido.getMarca();
		double distancia=recorrido.getRecorrido(); 
			
		
		switch (marca) {
		case "Toyota":
			mensaje="Señor "+nombre+" con la marca "+marca+" usted consumió "+distancia/40+" galones";
			break;
		case "Nisan":
			mensaje="Señor "+nombre+" con la marca "+marca+" usted consumió "+distancia/35+" galones";
			break;
		default:
			mensaje="Señor "+nombre+" con la marca "+marca+" usted consumió "+distancia/45+" galones";
			break;	
		}
		
		recorrido.setMensaje(mensaje);
		
		return "resultFrm";
		
		
	}

}
