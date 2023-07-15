package com.br.fraudservice.application.usecase;

import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.ports.input.IDisableFraudDomainUseCase;
import com.br.fraudservice.application.ports.output.IDisableFraudDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DisableFraudDomainUseCase implements IDisableFraudDomainUseCase {

    private final IDisableFraudDomainRepository iDisableFraudDomainRepository;

    @Override
    public FraudDomain execute(String document) {

        var fraud = FraudDomain.builder().document(document).build();

        fraud.setActive(false);
        fraud.setUpdatedAt(LocalDateTime.now());

        return fraud.disableFraud(iDisableFraudDomainRepository);
    }
}
