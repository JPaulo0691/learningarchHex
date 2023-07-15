package br.com.treinando.archHex.adapters.input.web.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailableCardsToClientRequest {
    private String document;
    private BigDecimal salary;
}
