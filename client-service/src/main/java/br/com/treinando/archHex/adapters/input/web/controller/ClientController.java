package br.com.treinando.archHex.adapters.input.web.controller;

import br.com.treinando.archHex.adapters.input.web.api.IClientApiEndPoints;
import br.com.treinando.archHex.adapters.input.web.api.exceptions.errors.ClientNotFoundException;
import br.com.treinando.archHex.adapters.input.web.api.request.AvailableCardsToClientRequest;
import br.com.treinando.archHex.adapters.input.web.api.request.ClientRequest;
import br.com.treinando.archHex.adapters.input.web.api.request.UpdateRequest;
import br.com.treinando.archHex.adapters.input.web.api.response.AvailableCardsForClientResponse;
import br.com.treinando.archHex.adapters.input.web.api.response.ClientResponse;
import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.mapper.ConverterDTO;
import br.com.treinando.archHex.application.ports.input.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController implements IClientApiEndPoints {

    private final ICreateClientDomainUseCase   iCreateClientDomainUseCase;
    private final IListAllClientDomainUseCase  iListAllClientDomainUseCase;
    private final IFindClientDomainByIdUseCase iFindClientDomainByIdUseCase;
    private final IUpdateClientDomainUseCase   iUpdateClientDomainUseCase;
    private final IDeleteClientDomainUseCase   iDeleteClientDomainUseCase;
    private final IListCreditCardAvailableUseCase iListCreditCardAvailableUseCase;

    // Object Converter
    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<ClientResponse> saveClient(ClientRequest clientRequest) {

        var domain = (ClientDomain) converterDTO.convertObjects(clientRequest, ClientDomain.class);
        var response = (ClientResponse) converterDTO.convertObjects(this.iCreateClientDomainUseCase.execute(domain)
                                                                  , ClientResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ClientResponse>> listAllClients() {

        var responseList = (List<ClientResponse>) converterDTO.convertObjectList(this.iListAllClientDomainUseCase.execute()
                                                                             , ClientResponse.class);
        return ResponseEntity.ok(responseList);
    }

    @Override
    public ResponseEntity<ClientResponse> findClientById(Long id) {

        try {
            var response = (ClientResponse) converterDTO.convertObjects(this.iFindClientDomainByIdUseCase.execute(id)
                    , ClientResponse.class);
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e){
            throw new ClientNotFoundException(id);
        }

    }

    @Override
    public ResponseEntity<ClientResponse> updateClient(UpdateRequest updateRequest, Long id) {

        var findClient = (ClientDomain) converterDTO.convertObjects(this.iFindClientDomainByIdUseCase.execute(id)
                                                                    ,ClientDomain.class);
        findClient.setEmail(updateRequest.getEmail());
        findClient.setPhone(updateRequest.getPhone());

        var response = (ClientResponse) converterDTO
                                       .convertObjects(this.iUpdateClientDomainUseCase.execute(findClient, findClient.getId())
                                                      ,ClientResponse.class);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> deleteClientById(Long id) {
        this.iDeleteClientDomainUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<AvailableCardsForClientResponse>> listOfAvailableCardToClient(AvailableCardsToClientRequest cardsToClientRequest) {

        var domain = (ClientDomain) converterDTO.convertObjects(cardsToClientRequest,ClientDomain.class);

        var response = (List<AvailableCardsForClientResponse>) converterDTO.convertObjectList(iListCreditCardAvailableUseCase
                                                                           .execute(domain.getDocument()
                                                                                    , domain.getSalary())
                                                                                     ,AvailableCardsForClientResponse.class);

        return ResponseEntity.ok(response);
    }


}
