package br.com.strawhat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Associado;
import br.com.strawhat.repository.AssociadoRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository repo;
	
	public Associado buscar(Integer id) {
		Optional<Associado> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Associado.class.getName()));
	}
}
