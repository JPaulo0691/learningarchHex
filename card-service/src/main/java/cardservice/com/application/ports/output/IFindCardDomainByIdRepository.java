package cardservice.com.application.ports.output;

import cardservice.com.application.domain.CardDomain;

public interface IFindCardDomainByIdRepository {
    CardDomain execute(Long id);
}
