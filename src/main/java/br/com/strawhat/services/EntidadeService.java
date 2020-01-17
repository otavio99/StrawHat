package br.com.strawhat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.strawhat.services.exceptions.DataIntegrityException;
import br.com.strawhat.model.Entidade;
import br.com.strawhat.repository.EntidadeRepository;

@Service
public class EntidadeService {
	
	@Autowired
	private EntidadeRepository repo;
	
	public Entidade find(Integer id) {
		Optional<Entidade> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Entidade.class.getName()));
	}
	
	public Entidade insert(Entidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Entidade update(Entidade obj) {
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

	public List<Entidade> findAll() {
		return repo.findAll();
	}
}