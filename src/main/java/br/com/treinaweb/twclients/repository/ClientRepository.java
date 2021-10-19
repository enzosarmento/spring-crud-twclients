package br.com.treinaweb.twclients.repository;

import br.com.treinaweb.twclients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
