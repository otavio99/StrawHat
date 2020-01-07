package br.com.strawhat.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.strawhat.model.Mensalidade;
import br.com.strawhat.services.MensalidadeService;

@RestController
@RequestMapping(value="/mensalidades")
public class MensalidadeResources {
	@Autowired
	private MensalidadeService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Mensalidade associado = service.buscar(id);
		return ResponseEntity.ok().body(associado);
	}
}
