package cardservice.com.application.ports.input;

import cardservice.com.application.domain.CardDomain;

import java.util.List;

public interface IListAllCardDomainUseCase {

    List<CardDomain> execute();
}
