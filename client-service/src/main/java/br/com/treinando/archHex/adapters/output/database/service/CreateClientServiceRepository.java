package br.com.treinando.archHex.adapters.output.database.service;

import br.com.treinando.archHex.adapters.output.database.entity.Client;
import br.com.treinando.archHex.adapters.output.database.repository.ClientRepository;
import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.mapper.ConverterDTO;
import br.com.treinando.archHex.application.ports.output.ICreateClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientServiceRepository implements ICreateClientDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public ClientDomain execute(ClientDomain clientDomain) {

        var entity = (Client) converterDTO.convertObjects(clientDomain, Client.class);
        var domain = (ClientDomain) converterDTO.convertObjects(this.clientRepository.save(entity)
                                                                ,ClientDomain.class);
        return domain;
    }
}
