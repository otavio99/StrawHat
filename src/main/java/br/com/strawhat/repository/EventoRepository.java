package br.com.strawhat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}