package br.com.strawhat;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.strawhat.model.Associado;
import br.com.strawhat.model.Batismo;
import br.com.strawhat.model.Entidade;
import br.com.strawhat.model.Mensalidade;
import br.com.strawhat.model.enums.TipoEvento;
import br.com.strawhat.repository.AssociadoRepository;
import br.com.strawhat.repository.BatismoRepository;
import br.com.strawhat.repository.EntidadeRepository;
import br.com.strawhat.repository.MensalidadeRepository;

@SpringBootApplication
public class StrawhatApplication implements CommandLineRunner{

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private EntidadeRepository entidadeRepository;
	
	@Autowired
	private MensalidadeRepository mensalidadeRepository;
	
	@Autowired
	private BatismoRepository batismoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StrawhatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Entidade entidade1 = new Entidade(null, "02/10", "Teste");
		Entidade entidade2 = new Entidade(null, "10/02", "Etset");
		
		Mensalidade mensalidade1 = new Mensalidade(null, "06/01/2020", 100);
		
		Associado associado1 = new Associado(null, "Luiz", "055", "123", "Rua do Ouvidor 327", "123", "24/10/1999");
		
		associado1.setMensalidades(Arrays.asList(mensalidade1));
		associado1.setPaisDeCabeca(Arrays.asList(entidade1, entidade2));
		
		mensalidade1.setAssociado(associado1);
		
		entidade1.setAfilhados(Arrays.asList(associado1));
		entidade2.setAfilhados(Arrays.asList(associado1));
		
		entidadeRepository.saveAll(Arrays.asList(entidade1, entidade2));
		associadoRepository.saveAll(Arrays.asList(associado1));
		mensalidadeRepository.saveAll(Arrays.asList(mensalidade1));
		
		associado1.setMensalidades(Arrays.asList(mensalidade1));
		associadoRepository.saveAll(Arrays.asList(associado1));
		
		ArrayList<Entidade> padrinhos = new ArrayList<Entidade>();
		padrinhos.add(entidade1);
		padrinhos.add(entidade2);
		
		Batismo evento1 = new Batismo(null, "05/01/2019", TipoEvento.BATISMO, "Luiz", "Gabi", padrinhos);
		evento1.setAssociado(associado1);
		
		entidade1.setBatismos(Arrays.asList(evento1));
		entidade2.setBatismos(Arrays.asList(evento1));
		
//		batismoRepository.saveAll(Arrays.asList(evento1));
		
		associado1.setEventos(Arrays.asList(evento1));
		
//		entidadeRepository.saveAll(Arrays.asList(entidade1, entidade2));
//		associadoRepository.saveAll(Arrays.asList(associado1));
//		mensalidadeRepository.saveAll(Arrays.asList(mensalidade1));
//		
		batismoRepository.saveAll(Arrays.asList(evento1));
		
		associadoRepository.saveAll(Arrays.asList(associado1));
	}
	
}
