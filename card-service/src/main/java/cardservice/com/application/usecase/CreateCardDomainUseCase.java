package cardservice.com.application.usecase;

import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.ports.input.ICreateCardDomainUseCase;
import cardservice.com.application.ports.output.ICreateCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCardDomainUseCase implements ICreateCardDomainUseCase {

    private final ICreateCardDomainRepository iCreateCardDomainRepository;

    @Override
    public CardDomain execute(CardDomain cardDomain) {
        return cardDomain.save(iCreateCardDomainRepository);
    }
}
