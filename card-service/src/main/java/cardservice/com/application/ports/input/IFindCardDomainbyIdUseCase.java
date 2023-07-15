package cardservice.com.application.ports.input;

import cardservice.com.application.domain.CardDomain;

public interface IFindCardDomainbyIdUseCase {

    CardDomain execute(Long id);
}
