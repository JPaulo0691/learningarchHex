package com.br.fraudservice.application.usecase;

import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.ports.input.ICheckFraudDomainActiveUseCase;
import com.br.fraudservice.application.ports.input.ICreateFraudDomainUseCase;
import com.br.fraudservice.application.ports.output.ICheckFraudDomainActiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckFraudDomainUseCase implements ICheckFraudDomainActiveUseCase {

    private final ICheckFraudDomainActiveRepository iCheckFraudDomainActiveRepository;


    @Override
    public FraudDomain execute(String document) {
        return FraudDomain.builder()
                          .document(document)
                          .build()
                          .checkActive(iCheckFraudDomainActiveRepository);
    }
}
