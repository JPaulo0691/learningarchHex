package br.com.treinando.archHex.adapters.input.web.api.exceptions.errors;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id){
        super(String.format("The client with the id-%d, wasn't found.", id));
    }
}
