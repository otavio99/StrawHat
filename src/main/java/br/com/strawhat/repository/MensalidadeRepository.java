package br.com.strawhat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Integer> {

}