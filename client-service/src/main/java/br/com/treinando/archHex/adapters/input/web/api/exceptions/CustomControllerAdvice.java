package br.com.treinando.archHex.adapters.input.web.api.exceptions;

import br.com.treinando.archHex.adapters.input.web.api.exceptions.errors.ClientApiErrorsResponse;
import br.com.treinando.archHex.adapters.input.web.api.exceptions.errors.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ClientApiErrorsResponse> handlerExceptionClientNotFound(ClientNotFoundException clientNotFoundException
                                                                         , WebRequest webRequest){

        var dataMessageErrors = ClientApiErrorsResponse.DataMessageErrors.builder()
                                                                    .message("The client wasn't found")
                                                                    .description(clientNotFoundException.getMessage())
                                                                    .localDateTime(LocalDateTime.now())
                                                                    .statusValue(HttpStatus.NOT_FOUND.value())
                                                                    .build();

        var apiError = ClientApiErrorsResponse.builder()
                .dataMessageErrors(dataMessageErrors)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ClientApiErrorsResponse>(apiError,HttpStatus.NOT_FOUND);
    }
}
