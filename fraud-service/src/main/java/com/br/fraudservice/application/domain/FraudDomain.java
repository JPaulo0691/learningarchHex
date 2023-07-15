package com.br.fraudservice.application.domain;

import com.br.fraudservice.application.ports.output.ICheckFraudDomainActiveRepository;
import com.br.fraudservice.application.ports.output.ICreateFraudDomainRepository;
import com.br.fraudservice.application.ports.output.IDisableFraudDomainRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudDomain {

    private Long id;
    private String document;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = null;

    public FraudDomain save(ICreateFraudDomainRepository iCreateFraudDomainRepository){
        return iCreateFraudDomainRepository.execute(this);
    }

    public FraudDomain checkActive(ICheckFraudDomainActiveRepository iCheckFraudDomainActiveRepository){
        return iCheckFraudDomainActiveRepository.execute(this.document);
    }

    public FraudDomain disableFraud(IDisableFraudDomainRepository iDisableFraudDomainRepository){
        return iDisableFraudDomainRepository.execute(this.document);
    }


}
