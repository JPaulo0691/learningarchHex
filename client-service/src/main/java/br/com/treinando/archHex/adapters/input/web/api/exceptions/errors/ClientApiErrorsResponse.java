package br.com.treinando.archHex.adapters.input.web.api.exceptions.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientApiErrorsResponse {

    private HttpStatus httpStatus;
    private DataMessageErrors dataMessageErrors;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataMessageErrors{

        private LocalDateTime localDateTime;
        private String message;
        private String description;
        private int statusValue;


    }

}
