package cardservice.com.application.usecase;

import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.ports.input.IListAllCardDomainUseCase;
import cardservice.com.application.ports.output.IListAllCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAllCardDomainUseCase implements IListAllCardDomainUseCase {

    private final IListAllCardDomainRepository iListAllCardDomainRepository;

    @Override
    public List<CardDomain> execute() {
        return CardDomain.builder()
                         .build()
                         .listAllCards(iListAllCardDomainRepository);
    }
}
