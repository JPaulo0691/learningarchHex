package com.br.fraudservice.adapters.output.database.h2.service;

import com.br.fraudservice.adapters.output.database.h2.repository.FraudRepository;
import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.mapper.ConverterDTO;
import com.br.fraudservice.application.ports.output.ICheckFraudDomainActiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckFraudServiceRepository implements ICheckFraudDomainActiveRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;

    @Override
    public FraudDomain execute(String document) {
        return (FraudDomain) converterDTO.convertObjects(this.fraudRepository.findByDocument(document)
                                                                , FraudDomain.class);
    }
}
