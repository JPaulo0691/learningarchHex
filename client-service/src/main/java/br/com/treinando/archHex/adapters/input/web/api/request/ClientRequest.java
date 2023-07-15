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
public class ClientRequest {

    private String name;
    private String email;
    private String phone;
    private BigDecimal salary;
    private String document;
}
