package br.com.strawhat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Entidade;
import br.com.strawhat.repository.EntidadeRepository;

@Service
public class EntidadeService {
	
	@Autowired
	private EntidadeRepository repo;
	
	public Entidade buscar(Integer id) {
		Optional<Entidade> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Entidade.class.getName()));
	}
}
