package br.com.treinando.archHex.application.ports.output;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;

public interface IFindClientDomainByIdRepository {
    ClientDomain execute(Long id);
}