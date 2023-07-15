package br.com.treinando.archHex.adapters.input.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private BigDecimal salary;
    private String document;
}
