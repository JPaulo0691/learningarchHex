package cardservice.com.adapters.output.database.postgres.service;

import cardservice.com.adapters.output.database.postgres.entity.Card;
import cardservice.com.adapters.output.database.postgres.repository.CardRepository;
import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.mapper.ConvertDTO;
import cardservice.com.application.ports.output.IUpdateCardLimitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCardLimitServiceRepository implements IUpdateCardLimitRepository {

    private final CardRepository cardRepository;
    private final ConvertDTO convertDTO;

    @Override
    public CardDomain execute(CardDomain cardDomain, Long id) {

        var cardConvert = (Card) convertDTO.convertObjects(cardDomain, Card.class);

        var card = this.cardRepository.findById(id).get();
        card.setCard_limit(cardConvert.getCard_limit());

        return (CardDomain) convertDTO.convertObjects(this.cardRepository.save(card)
                                                     , CardDomain.class);
    }
}
