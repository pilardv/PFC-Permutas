package es.us.pfc.permuta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.us.pfc.permuta.entities.Provincia;
import es.us.pfc.permuta.repositories.ProvinciaRepository;

@Controller
public class RegistroController {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
    
    @RequestMapping(value="/registro", method = {RequestMethod.GET})
	@Transactional(readOnly=true)
	public ModelAndView find(){	
    	
    	Iterable<Provincia> provincias = provinciaRepository.findAll();
    	
    	ModelAndView mavProvincias = new ModelAndView("registro");
    	mavProvincias.addObject("provincias",provincias);
		return mavProvincias;
    	
	}
    
    @RequestMapping(value="/registro", method = {RequestMethod.POST})
	@Transactional(readOnly=true)
	public ModelAndView insert(){		
					
    	ModelAndView mav = new ModelAndView("registro");
		return mav;
	}
	
}