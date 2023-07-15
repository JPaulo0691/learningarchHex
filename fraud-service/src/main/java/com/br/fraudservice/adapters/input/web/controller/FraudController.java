package com.br.fraudservice.adapters.input.web.controller;

import com.br.fraudservice.adapters.input.web.api.FraudApi;
import com.br.fraudservice.adapters.input.web.api.request.FraudRequest;
import com.br.fraudservice.adapters.input.web.api.response.CheckActiveFraudResponse;
import com.br.fraudservice.adapters.input.web.api.response.FraudResponse;
import com.br.fraudservice.application.domain.FraudDomain;
import com.br.fraudservice.application.mapper.ConverterDTO;
import com.br.fraudservice.application.ports.input.ICheckFraudDomainActiveUseCase;
import com.br.fraudservice.application.ports.input.ICreateFraudDomainUseCase;
import com.br.fraudservice.application.ports.input.IDisableFraudDomainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FraudController implements FraudApi {

    private final ICreateFraudDomainUseCase iCreateFraudDomainUseCase;
    private final ICheckFraudDomainActiveUseCase iCheckFraudDomainActiveUseCase;
    private final IDisableFraudDomainUseCase iDisableFraudDomainUseCase;

    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<FraudResponse> saveFraud(FraudRequest fraudRequest) {
        var domain = (FraudDomain) converterDTO.convertObjects(fraudRequest, FraudDomain.class);
        var response = (FraudResponse) converterDTO.convertObjects(this.iCreateFraudDomainUseCase.execute(domain)
                                                                   , FraudResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CheckActiveFraudResponse> checkFraud(String documento) {

        var response = (CheckActiveFraudResponse) converterDTO.convertObjects(this.iCheckFraudDomainActiveUseCase.execute(documento)
                                                                                , CheckActiveFraudResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CheckActiveFraudResponse> disableActiveFraud(String documento) {

        var response = (CheckActiveFraudResponse) converterDTO.convertObjects(this.iDisableFraudDomainUseCase.execute(documento)
                                                                    , CheckActiveFraudResponse.class);
        return ResponseEntity.ok(response);
    }
}
