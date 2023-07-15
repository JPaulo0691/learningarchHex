package cardservice.com.adapters.output.database.postgres.service;

import cardservice.com.adapters.output.database.postgres.entity.Card;
import cardservice.com.adapters.output.database.postgres.repository.CardRepository;
import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.mapper.ConvertDTO;
import cardservice.com.application.ports.output.ICreateCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardServiceRepository implements ICreateCardDomainRepository {

    private final CardRepository cardRepository;
    private final ConvertDTO convertDTO;

    @Override
    public CardDomain execute(CardDomain cardDomain) {

        var cardEntity = (Card) convertDTO.convertObjects(cardDomain, Card.class);

        return (CardDomain) convertDTO.convertObjects(this.cardRepository.save(cardEntity)
                                                     , CardDomain.class);
    }
}
