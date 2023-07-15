package br.com.treinando.archHex.application.ports.input;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;

public interface IUpdateClientDomainUseCase {

    ClientDomain execute(ClientDomain clientDomain, Long id);
}
