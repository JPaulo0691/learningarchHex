package br.com.treinando.archHex.application.ports.input;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;

import java.util.List;

public interface IListAllClientDomainUseCase {

    List<ClientDomain> execute();
}
