package com.br.fraudservice.application.ports.output;

import com.br.fraudservice.application.domain.FraudDomain;

public interface ICheckFraudDomainActiveRepository {

    FraudDomain execute(String document);
}
