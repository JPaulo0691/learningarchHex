package cardservice.com.application.ports.output;

import cardservice.com.application.domain.CardDomain;

import java.util.List;

public interface IListAllCardDomainRepository {

    List<CardDomain> execute();
}
