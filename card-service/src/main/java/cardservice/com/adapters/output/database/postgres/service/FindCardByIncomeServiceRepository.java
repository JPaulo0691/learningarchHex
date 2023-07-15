package cardservice.com.adapters.output.database.postgres.service;

import cardservice.com.adapters.output.database.postgres.repository.CardRepository;
import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.mapper.ConvertDTO;
import cardservice.com.application.ports.output.IFindCardDomainByIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class FindCardByIncomeServiceRepository implements IFindCardDomainByIncomeRepository {

    private final CardRepository cardRepository;
    private final ConvertDTO convertDTO;

    @Override
    public List<CardDomain> execute(BigDecimal income) {
        return (List<CardDomain>) convertDTO.convertObjectList(this.cardRepository.findByIncomeLessThanEqual(income)
                                                              ,CardDomain.class);
    }
}
