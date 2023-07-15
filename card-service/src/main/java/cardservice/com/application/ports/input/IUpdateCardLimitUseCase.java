package cardservice.com.application.ports.input;

import cardservice.com.application.domain.CardDomain;

public interface IUpdateCardLimitUseCase {

    CardDomain execute(CardDomain cardDomain, Long id);
}
