package com.br.fraudservice.adapters.input.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckActiveFraudResponse {

    private String document;
    private boolean active;
    private LocalDateTime updatedAt;

}
