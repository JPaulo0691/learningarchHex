package cardservice.com.application.ports.output;

import cardservice.com.application.domain.CardDomain;

import java.math.BigDecimal;
import java.util.List;

public interface IFindCardDomainByIncomeRepository {
    List<CardDomain> execute(BigDecimal income);
}
