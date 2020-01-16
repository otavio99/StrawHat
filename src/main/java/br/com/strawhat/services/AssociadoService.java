package br.com.strawhat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.strawhat.services.exceptions.DataIntegrityException;

import br.com.strawhat.model.Associado;
import br.com.strawhat.repository.AssociadoRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository repo;
	
	public Associado find(Integer id) {
		Optional<Associado> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Associado.class.getName()));
	}
	
	public Associado insert(Associado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Associado update(Associado obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Associado que possui produtos.");
		}
	}

	public List<Associado> findAll() {
		return repo.findAll();
	}
}
