package cardservice.com.application.ports.output;

import cardservice.com.application.domain.CardDomain;

public interface ICreateCardDomainRepository {
    CardDomain execute(CardDomain cardDomain);
}
