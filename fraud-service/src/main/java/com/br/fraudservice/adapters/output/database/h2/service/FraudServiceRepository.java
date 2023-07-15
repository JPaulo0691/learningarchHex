package com.br.fraudservice.adapters.output.database.h2.service;

import com.br.fraudservice.adapters.output.database.h2.entity.Fraud;
import com.br.fraudservice.adapters.output.database.h2.repository.FraudRepository;
import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.mapper.ConverterDTO;
import com.br.fraudservice.application.ports.output.ICreateFraudDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudServiceRepository implements ICreateFraudDomainRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;

    @Override
    public FraudDomain execute(FraudDomain fraudDomain) {

        var entity = (Fraud) converterDTO.convertObjects(fraudDomain, Fraud.class);

        return (FraudDomain) converterDTO.convertObjects(this.fraudRepository.save(entity)
                                                            , FraudDomain.class);
    }
}
