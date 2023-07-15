package br.com.treinando.archHex.application.ports.input;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;

public interface IFindClientDomainByIdUseCase {

    ClientDomain execute(Long id);
}
