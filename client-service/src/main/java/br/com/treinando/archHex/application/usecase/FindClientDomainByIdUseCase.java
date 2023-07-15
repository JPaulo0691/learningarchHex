package br.com.treinando.archHex.application.usecase;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.ports.input.IFindClientDomainByIdUseCase;
import br.com.treinando.archHex.application.ports.output.IFindClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindClientDomainByIdUseCase implements IFindClientDomainByIdUseCase {

    private final IFindClientDomainByIdRepository iFindClientDomainByIdDomainRepository;

    @Override
    public ClientDomain execute(Long id) {
        return ClientDomain.builder()
                           .id(id)
                           .build()
                           .findById(iFindClientDomainByIdDomainRepository);
    }
}
