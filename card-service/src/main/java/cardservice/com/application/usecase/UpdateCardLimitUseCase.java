package cardservice.com.application.usecase;

import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.ports.input.IUpdateCardLimitUseCase;
import cardservice.com.application.ports.output.IFindCardDomainByIdRepository;
import cardservice.com.application.ports.output.IUpdateCardLimitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCardLimitUseCase implements IUpdateCardLimitUseCase {

    private final IUpdateCardLimitRepository iUpdateCardLimitRepository;

    @Override
    public CardDomain execute(CardDomain cardDomain, Long id) {

        var idCard = CardDomain.builder()
                                          .id(id)
                                          .build();

        idCard.setCard_limit(cardDomain.getCard_limit());

        return idCard.updateCardLimit(iUpdateCardLimitRepository);

    }
}
