package br.com.strawhat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.strawhat.dto.EntidadeDTO;
import br.com.strawhat.model.Entidade;
import br.com.strawhat.repository.EntidadeRepository;
import br.com.strawhat.services.exceptions.DataIntegrityException;

@Service
public class EntidadeService {

	@Autowired
	private EntidadeRepository repo;

	public Entidade find(Integer id) {
		Optional<Entidade> associado = repo.findById(id);
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Entidade.class.getName()));
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
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}

	public List<Entidade> findAll() {
		return repo.findAll();
	}

	public Page<Entidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Entidade fromDTO(EntidadeDTO objDto) {
		return new Entidade(objDto.getId(), objDto.getData(), objDto.getNome());
	}
}
