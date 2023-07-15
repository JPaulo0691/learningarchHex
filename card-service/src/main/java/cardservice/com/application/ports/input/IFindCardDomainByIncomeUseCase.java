package cardservice.com.application.ports.input;

import cardservice.com.application.domain.CardDomain;

import java.math.BigDecimal;
import java.util.List;

public interface IFindCardDomainByIncomeUseCase {
    List<CardDomain> execute(BigDecimal income);
}
