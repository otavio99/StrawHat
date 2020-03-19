package br.com.strawhat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Mensalidade;
import br.com.strawhat.repository.MensalidadeRepository;
import br.com.strawhat.services.exceptions.DataIntegrityException;

@Service
public class MensalidadeService {

	@Autowired
	private MensalidadeRepository repo;

	public Mensalidade find(Integer id) {
		Optional<Mensalidade> associado = repo.findById(id);
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Mensalidade.class.getName()));
	}

	public Mensalidade insert(Mensalidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Mensalidade update(Mensalidade obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Mensalidade porque possui um Mensalidade vinculado.");
		}
	}

	public List<Mensalidade> findAll() {
		return repo.findAll();
	}

	public Page<Mensalidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
