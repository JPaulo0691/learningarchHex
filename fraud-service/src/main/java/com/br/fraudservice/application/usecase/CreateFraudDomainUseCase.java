package com.br.fraudservice.application.usecase;

import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.ports.input.ICreateFraudDomainUseCase;
import com.br.fraudservice.application.ports.output.ICreateFraudDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateFraudDomainUseCase implements ICreateFraudDomainUseCase {

    private final ICreateFraudDomainRepository iCreateFraudDomainRepository;

    @Override
    public FraudDomain execute(FraudDomain fraudDomain) {
        return fraudDomain.save(iCreateFraudDomainRepository);
    }
}
