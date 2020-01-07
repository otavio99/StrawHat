package br.com.strawhat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.strawhat.model.Mensalidade;
import br.com.strawhat.repository.MensalidadeRepository;

@Service
public class MensalidadeService {
	
	@Autowired
	private MensalidadeRepository repo;
	
	public Mensalidade buscar(Integer id) {
		Optional<Mensalidade> associado = repo.findById(id); 
		return associado.orElseThrow(() -> new br.com.strawhat.services.exceptions.
				ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Mensalidade.class.getName()));
	}
}
