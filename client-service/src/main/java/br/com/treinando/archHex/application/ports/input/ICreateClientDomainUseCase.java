package br.com.treinando.archHex.application.ports.input;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
public interface ICreateClientDomainUseCase {
    ClientDomain execute(ClientDomain clientDomain);
}
