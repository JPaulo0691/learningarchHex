package br.com.treinando.archHex.adapters.output.database.service;

import br.com.treinando.archHex.adapters.output.database.repository.ClientRepository;
import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.mapper.ConverterDTO;
import br.com.treinando.archHex.application.ports.output.IFindClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindClientByIdServiceRepository implements IFindClientDomainByIdRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public ClientDomain execute(Long id) {
        return (ClientDomain) converterDTO.convertObjects(this.clientRepository.findById(id)
                                                          , ClientDomain.class);
    }
}
