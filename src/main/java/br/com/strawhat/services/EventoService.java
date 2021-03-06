package br.com.strawhat.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Batismo;
import br.com.strawhat.model.Entidade;
import br.com.strawhat.model.Evento;
import br.com.strawhat.repository.EntidadeRepository;
import br.com.strawhat.repository.EventoRepository;
import br.com.strawhat.services.exceptions.DataIntegrityException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repo;

	@Autowired
	private EntidadeRepository entidadeRepository;

	public Evento find(Integer id) {
		Optional<Evento> associado = repo.findById(id);
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Evento.class.getName()));
	}

	public Evento insert(Evento obj) {
		obj.setId(null);

		if (obj instanceof Batismo) {
			List<Entidade> padrinhos = ((Batismo) obj).getPadrinhosEspirituais();
			List<Entidade> padrinhosParaSettar = new LinkedList<Entidade>();

			((Batismo) obj).setPadrinhosEspirituais(null);
			repo.save(obj);

			for (Entidade entidade : padrinhos) {
				Entidade e = entidadeRepository.findById(entidade.getId()).get();
				e.getBatismos().add((Batismo) obj);
				entidadeRepository.save(e);

				padrinhosParaSettar.add(e);
			}

			((Batismo) obj).setPadrinhosEspirituais(padrinhosParaSettar);
		}

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
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}

	public List<Evento> findAll() {
		return repo.findAll();
	}

	public Page<Evento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
