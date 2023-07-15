package cardservice.com.application.domain;

import cardservice.com.application.ports.output.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDomain {

    private Long id;
    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;

    public CardDomain save(ICreateCardDomainRepository iCreateCardDomainRepository){
        return iCreateCardDomainRepository.execute(this);
    }

    public List<CardDomain> listAllCards(IListAllCardDomainRepository listAllCardDomainRepository){
        return listAllCardDomainRepository.execute();
    }

    public CardDomain findById(IFindCardDomainByIdRepository iFindCardDomainByIdRepository){
        return iFindCardDomainByIdRepository.execute(this.id);
    }

    public CardDomain updateCardLimit(IUpdateCardLimitRepository iUpdateCardLimitRepository){

        return iUpdateCardLimitRepository.execute(this,this.id);
    }

    public List<CardDomain> findCardByIncome(IFindCardDomainByIncomeRepository iFindCardDomainByIncomeRepository){
        return iFindCardDomainByIncomeRepository.execute(this.income);
    }

}
