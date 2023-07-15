package com.br.fraudservice.application.ports.input;

import com.br.fraudservice.application.domain.FraudDomain;

public interface IDisableFraudDomainUseCase {

    FraudDomain execute(String document);
}
