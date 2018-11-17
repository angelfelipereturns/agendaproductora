package com.afaf.agendaproductora.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afaf.agendaproductora.data.model.Contacto;
import com.afaf.agendaproductora.service.ContactoService;

@RestController
public class ContactoRestController {
	
	@Autowired
	private ContactoService contactoService;
	
	@RequestMapping(value="/contactos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> contactoTodos() {
		return contactoService.contactoTodos();
	}
	
	@RequestMapping(value="/contactos/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contacto> contactoPorId(@PathVariable Long id) {
		ResponseEntity<Contacto> response = ResponseEntity.notFound().build();
		Optional<Contacto> contacto = contactoService.contactoPorId(id);
		if (contacto.isPresent()) {
			response = new ResponseEntity<>(contacto.get(), HttpStatus.OK);
			
		}
        return response;
	}
	
	@RequestMapping(value="/contactos/nuevo", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> contactoNuevo(@RequestBody Contacto contacto) {
		ResponseEntity<String> response = ResponseEntity.notFound().build();
		Contacto contactoNuevo = contactoService.contactoSave(contacto);
		if(null!=contactoNuevo) {
			response = new ResponseEntity<>("contacto creado correctamente", HttpStatus.CREATED);
		}
        return response;
    }
 
    @RequestMapping(value="/contactos/modificar/{id}", method=RequestMethod.PUT, produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> contactoModificar(@PathVariable Long id, @RequestBody Contacto contacto) {
    	ResponseEntity<String> response = ResponseEntity.notFound().build();
    	Optional<Contacto> contactoBD = contactoService.contactoPorId(id);
        if (contactoBD.isPresent()) {
        	contacto.setId(id);
        	Contacto contactoModificado = contactoService.contactoSave(contacto);
        	if(null!=contactoModificado) {
    			response = new ResponseEntity<>("contacto modificado correctamente", HttpStatus.OK);
    		}
        }
        return response;
    }
 
    @RequestMapping(value="/contactos/borrar/{id}", method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> contactoBorrar(@PathVariable Long id) {
    	ResponseEntity<String> response = ResponseEntity.notFound().build();
    	contactoService.contactoBorrar(id);
    	Optional<Contacto> contactoBD = contactoService.contactoPorId(id);
    	if(!contactoBD.isPresent()) {
			response = new ResponseEntity<>("contacto eliminado correctamente", HttpStatus.OK);
		}
        return response;
    }

}
