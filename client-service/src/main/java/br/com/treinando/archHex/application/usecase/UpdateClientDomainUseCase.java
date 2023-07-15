package br.com.treinando.archHex.application.usecase;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.ports.input.IUpdateClientDomainUseCase;
import br.com.treinando.archHex.application.ports.output.IFindClientDomainByIdRepository;
import br.com.treinando.archHex.application.ports.output.IUpdateDataClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateClientDomainUseCase implements IUpdateClientDomainUseCase {

    private final IUpdateDataClientDomainRepository iUpdateDataClientDomainRepository;
    private final IFindClientDomainByIdRepository iFindClientDomainByIdRepository;

    @Override
    public ClientDomain execute(ClientDomain clientDomain, Long id) {

        return clientDomain
                           .updateData(iUpdateDataClientDomainRepository,iFindClientDomainByIdRepository);
    }
}
