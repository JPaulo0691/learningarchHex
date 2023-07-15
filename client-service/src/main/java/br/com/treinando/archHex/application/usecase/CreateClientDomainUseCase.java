package br.com.treinando.archHex.application.usecase;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.ports.input.ICreateClientDomainUseCase;
import br.com.treinando.archHex.application.ports.output.ICreateClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientDomainUseCase implements ICreateClientDomainUseCase {

    private final ICreateClientDomainRepository iCreateClientDomainRepository;

    @Override
    public ClientDomain execute(ClientDomain clientDomain) {

        return clientDomain.save(iCreateClientDomainRepository);
    }
}
