package cardservice.com.adapters.output.database.postgres.service;

import cardservice.com.adapters.output.database.postgres.repository.CardRepository;
import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.mapper.ConvertDTO;
import cardservice.com.application.ports.output.IListAllCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAllCardsServiceRepository implements IListAllCardDomainRepository {

    private final CardRepository cardRepository;
    private final ConvertDTO convertDTO;

    @Override
    public List<CardDomain> execute() {

        return (List<CardDomain>) convertDTO.convertObjectList(this.cardRepository.findAll()
                                                      , CardDomain.class);
    }
}
