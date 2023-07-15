package br.com.treinando.archHex.application.usecase;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.ports.input.IListAllClientDomainUseCase;
import br.com.treinando.archHex.application.ports.output.IListAllClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAllClientDomainUseCase implements IListAllClientDomainUseCase {

    private final IListAllClientDomainRepository iListAllClientDomainRepository;

    @Override
    public List<ClientDomain> execute() {

        return ClientDomain.builder()
                           .build()
                           .findAllClients(iListAllClientDomainRepository);
    }
}
