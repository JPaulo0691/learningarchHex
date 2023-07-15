package br.com.treinando.archHex.adapters.output.database.service;

import br.com.treinando.archHex.adapters.output.database.repository.ClientRepository;
import br.com.treinando.archHex.application.ports.output.IDeleteClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientServiceRepository implements IDeleteClientDomainRepository {

    private final ClientRepository clientRepository;

    @Override
    public void execute(Long id) {
        this.clientRepository.deleteById(id);
    }
}
