package com.br.fraudservice.application.ports.output;

import com.br.fraudservice.application.domain.FraudDomain;

public interface IDisableFraudDomainRepository {
    FraudDomain execute(String document);
}
