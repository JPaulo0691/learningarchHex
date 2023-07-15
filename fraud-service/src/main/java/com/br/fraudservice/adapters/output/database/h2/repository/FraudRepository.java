package com.br.fraudservice.adapters.output.database.h2.repository;

import com.br.fraudservice.adapters.output.database.h2.entity.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud, Long> {

    Fraud findByDocument(String documento);
}
