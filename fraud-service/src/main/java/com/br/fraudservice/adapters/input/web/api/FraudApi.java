package com.br.fraudservice.adapters.input.web.api;

import com.br.fraudservice.adapters.input.web.api.request.FraudRequest;
import com.br.fraudservice.adapters.input.web.api.response.CheckActiveFraudResponse;
import com.br.fraudservice.adapters.input.web.api.response.FraudResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/fraud")
public interface FraudApi {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<FraudResponse> saveFraud(@RequestBody FraudRequest fraudRequest);

    @GetMapping("/checkFraud")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CheckActiveFraudResponse> checkFraud(@RequestParam("documento") String documento);

    @PutMapping("/updateActiveFraud")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CheckActiveFraudResponse> disableActiveFraud(@RequestParam("documento") String documento);
}
