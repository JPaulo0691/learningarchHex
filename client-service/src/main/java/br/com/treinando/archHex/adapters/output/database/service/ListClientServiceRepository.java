package br.com.treinando.archHex.adapters.output.database.service;

import br.com.treinando.archHex.adapters.output.database.repository.ClientRepository;
import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.mapper.ConverterDTO;
import br.com.treinando.archHex.application.ports.output.IListAllClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListClientServiceRepository implements IListAllClientDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public List<ClientDomain> execute() {
        return (List<ClientDomain>)converterDTO.convertObjectList(this.clientRepository.findAll()
                                                                            , ClientDomain.class);
    }
}
