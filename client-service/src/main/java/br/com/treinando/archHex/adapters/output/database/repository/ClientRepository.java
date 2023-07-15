package br.com.treinando.archHex.adapters.output.database.repository;

import br.com.treinando.archHex.adapters.output.database.entity.Client;
import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import cardservice.com.adapters.output.database.postgres.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByDocumentAndSalary(String document, BigDecimal salary);
}
