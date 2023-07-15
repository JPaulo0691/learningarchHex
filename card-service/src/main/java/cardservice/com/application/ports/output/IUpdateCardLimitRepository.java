package cardservice.com.application.ports.output;

import cardservice.com.application.domain.CardDomain;

public interface IUpdateCardLimitRepository {
    CardDomain execute(CardDomain cardDomain, Long id);
}
