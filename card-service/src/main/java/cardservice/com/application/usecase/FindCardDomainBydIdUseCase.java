package cardservice.com.application.usecase;

import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.ports.input.IFindCardDomainbyIdUseCase;
import cardservice.com.application.ports.output.IFindCardDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCardDomainBydIdUseCase implements IFindCardDomainbyIdUseCase {

    private final IFindCardDomainByIdRepository iFindCardDomainByIdRepository;

    @Override
    public CardDomain execute(Long id) {
        return CardDomain.builder()
                         .id(id)
                         .build()
                         .findById(iFindCardDomainByIdRepository);
    }
}
