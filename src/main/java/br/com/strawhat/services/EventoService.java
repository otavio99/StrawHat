package br.com.strawhat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Evento;
import br.com.strawhat.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repo;
	
	public Evento buscar(Integer id) {
		Optional<Evento> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Evento.class.getName()));
	}
}
