package cardservice.com.application.ports.input;

import cardservice.com.application.domain.CardDomain;

public interface ICreateCardDomainUseCase {

    CardDomain execute(CardDomain cardDomain);
}
