package cardservice.com.adapters.output.database.postgres.service;

import cardservice.com.adapters.output.database.postgres.repository.CardRepository;
import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.mapper.ConvertDTO;
import cardservice.com.application.ports.output.IFindCardDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCardByIdServiceRespository implements IFindCardDomainByIdRepository {

    private final CardRepository cardRepository;
    private final ConvertDTO convertDTO;

    @Override
    public CardDomain execute(Long id) {
        return (CardDomain) convertDTO.convertObjects(this.cardRepository.findById(id)
                                                     , CardDomain.class);
    }
}
