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
public class FraudResponse {

    private Long id;
    private String document;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
