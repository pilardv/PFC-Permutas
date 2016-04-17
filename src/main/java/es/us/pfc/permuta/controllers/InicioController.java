package es.us.pfc.permuta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.us.pfc.permuta.entities.DatosPlazaDeseada;
import es.us.pfc.permuta.entities.Persona;
import es.us.pfc.permuta.repositories.DatosPlazaDeseadaRepository;
import es.us.pfc.permuta.repositories.PersonaRepository;
import es.us.pfc.permuta.security.LoginService;

@Controller
public class InicioController {

	@Autowired
	private PersonaRepository personaRepository;
	private DatosPlazaDeseadaRepository datosPlazaDeseadaRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView find(){		
		Integer usuarioId = LoginService.getPrincipal().getId();
		
		if(null == usuarioId){
			throw new UsernameNotFoundException("No existe un usuario: " + LoginService.getPrincipal().getNombreUsuario());
		}else{
			Persona persona = personaRepository.findByUsuarioId(usuarioId);
			
//			List<DatosPlazaDeseada> plazasDeseadas = datosPlazaDeseadaRepository.findPlazasDeseadasByUsuarioId(usuarioId);
			
			ModelAndView mav = new ModelAndView("home");
			mav.addObject("persona",persona);
//			mav.addObject("nuevaPersona", new Persona());
			return mav;
		} 
	}
 
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String index() {         
        return "welcome";
        
    }
 
}