package br.com.treinando.archHex.application.domain.entity;

import br.com.treinando.archHex.application.ports.output.*;
import cardservice.com.adapters.output.database.postgres.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDomain {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private BigDecimal salary;
    private List<Card> cards;

    public ClientDomain save(ICreateClientDomainRepository iCreateClientDomainRepository){
        return iCreateClientDomainRepository.execute(this);
    }

    public List<ClientDomain> findAllClients(IListAllClientDomainRepository iListAllClientDomainRepository){
        return iListAllClientDomainRepository.execute();
    }

    public ClientDomain findById(IFindClientDomainByIdRepository iFindClientByIdDomainRepository){
        return iFindClientByIdDomainRepository.execute(this.id);
    }

    public ClientDomain updateData(IUpdateDataClientDomainRepository iUpdateDataClientDomainRepository,
                                   IFindClientDomainByIdRepository iFindClientDomainByIdRepository){

        var findById = iFindClientDomainByIdRepository.execute(this.id);

        return iUpdateDataClientDomainRepository.execute(this, findById.id);
    }

    public void deleteClient(IDeleteClientDomainRepository iDeleteClientDomainRepository){
        iDeleteClientDomainRepository.execute(this.id);
    }

    public List<Card> availableCreditCardsForClient(IListCreditCardAvailableDomainRepository iListCreditCardAvailableDomain){
        return iListCreditCardAvailableDomain.execute(this.document, this.salary);
    }
}