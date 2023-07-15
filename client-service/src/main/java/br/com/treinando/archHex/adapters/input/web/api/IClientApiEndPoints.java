package br.com.treinando.archHex.adapters.input.web.api;

import br.com.treinando.archHex.adapters.input.web.api.request.AvailableCardsToClientRequest;
import br.com.treinando.archHex.adapters.input.web.api.request.ClientRequest;
import br.com.treinando.archHex.adapters.input.web.api.request.UpdateRequest;
import br.com.treinando.archHex.adapters.input.web.api.response.AvailableCardsForClientResponse;
import br.com.treinando.archHex.adapters.input.web.api.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("api/v1/serviceclient")
public interface IClientApiEndPoints {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientResponse> saveClient(@RequestBody ClientRequest clientRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientResponse>> listAllClients();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ClientResponse> findClientById(@PathVariable("id")Long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ClientResponse> updateClient(@RequestBody UpdateRequest updateRequest
                                              , @PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<?> deleteClientById(@PathVariable("id")Long id);

    @GetMapping("/availableCard")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<AvailableCardsForClientResponse>> listOfAvailableCardToClient(@RequestBody AvailableCardsToClientRequest cardsToClientRequest);

}
