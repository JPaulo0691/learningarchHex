package br.com.treinando.archHex.adapters.output.database.service;

import br.com.treinando.archHex.adapters.output.database.entity.Client;
import br.com.treinando.archHex.adapters.output.database.repository.ClientRepository;
import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.mapper.ConverterDTO;
import br.com.treinando.archHex.application.ports.output.IUpdateDataClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateClientServiceRepository implements IUpdateDataClientDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;


    @Override
    public ClientDomain execute(ClientDomain clientDomain, Long id) {

        var entity = this.clientRepository.findById(id).get();
        entity.setPhone(clientDomain.getPhone());
        entity.setEmail(clientDomain.getEmail());

        var domain = (ClientDomain) converterDTO.convertObjects(this.clientRepository.save(entity),ClientDomain.class);

        return domain;
    }
}
