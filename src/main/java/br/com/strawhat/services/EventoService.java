package br.com.strawhat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Evento;
import br.com.strawhat.repository.EventoRepository;
import br.com.strawhat.services.exceptions.DataIntegrityException;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repo;
	
	public Evento find(Integer id) {
		Optional<Evento> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Evento.class.getName()));
	}

	public Evento insert(Evento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Evento update(Evento obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}

	public List<Evento> findAll() {
		return repo.findAll();
	}
}
