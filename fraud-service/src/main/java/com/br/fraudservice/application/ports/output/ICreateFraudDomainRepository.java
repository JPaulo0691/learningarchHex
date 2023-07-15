package com.br.fraudservice.application.ports.output;

import com.br.fraudservice.application.domain.FraudDomain;

public interface ICreateFraudDomainRepository {
    FraudDomain execute(FraudDomain fraudDomain);
}
