package com.br.fraudservice.adapters.output.database.h2.service;

import com.br.fraudservice.adapters.output.database.h2.repository.FraudRepository;
import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.mapper.ConverterDTO;
import com.br.fraudservice.application.ports.output.IDisableFraudDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DisableFraudServiceRepository implements IDisableFraudDomainRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;

    @Override
    public FraudDomain execute(String document) {

        var entity = fraudRepository.findByDocument(document);
        entity.setActive(false);
        entity.setUpdatedAt(LocalDateTime.now());

        return (FraudDomain) converterDTO.convertObjects(this.fraudRepository.save(entity)
                                                        , FraudDomain.class);
    }
}
