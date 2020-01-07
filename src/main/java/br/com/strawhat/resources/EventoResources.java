package br.com.strawhat.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.strawhat.model.Evento;
import br.com.strawhat.services.EventoService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResources {
	@Autowired
	private EventoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Evento associado = service.buscar(id);
		return ResponseEntity.ok().body(associado);
	}
}
