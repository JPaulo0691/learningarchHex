package br.com.treinando.archHex.application.usecase;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.ports.input.IDeleteClientDomainUseCase;
import br.com.treinando.archHex.application.ports.output.IDeleteClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientDomainUseCase implements IDeleteClientDomainUseCase {

    private final IDeleteClientDomainRepository iDeleteClientDomainRepository;

    @Override
    public void execute(Long id) {
        ClientDomain.builder()
                    .id(id)
                    .build()
                    .deleteClient(iDeleteClientDomainRepository);
    }
}

