package cardservice.com.application.usecase;

import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.ports.input.IFindCardDomainByIncomeUseCase;
import cardservice.com.application.ports.output.IFindCardDomainByIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class FindCardDomainByIncome implements IFindCardDomainByIncomeUseCase {

    private final IFindCardDomainByIncomeRepository iFindCardDomainByIncomeRepository;

    @Override
    public List<CardDomain> execute(BigDecimal income) {
        return CardDomain.builder()
                         .income(income)
                         .build()
                         .findCardByIncome(iFindCardDomainByIncomeRepository);
    }
}
