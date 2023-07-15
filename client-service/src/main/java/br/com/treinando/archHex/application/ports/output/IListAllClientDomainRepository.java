package br.com.treinando.archHex.application.ports.output;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;

import java.util.List;

public interface IListAllClientDomainRepository {
    List<ClientDomain> execute();
}
