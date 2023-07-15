package br.com.treinando.archHex.adapters.output.database.service;

import br.com.treinando.archHex.adapters.output.database.repository.ClientRepository;
import br.com.treinando.archHex.application.ports.output.IListCreditCardAvailableDomainRepository;
import cardservice.com.adapters.output.database.postgres.entity.Card;
import cardservice.com.adapters.output.database.postgres.repository.CardRepository;
import cardservice.com.application.mapper.ConvertDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ListAvailableCreditCard implements IListCreditCardAvailableDomainRepository {

    private final ClientRepository clientRepository;
    private final CardRepository cardRepository;
    private final ConvertDTO convertDTO;

    @Override
    public List<Card> execute(String document, BigDecimal salary) {

        var client = this.clientRepository.findByDocumentAndSalary(document,salary);
        var availableListCard = this.cardRepository.findAll();

        var cards = (Card) convertDTO.convertObjectList(availableListCard, Card.class);

        if(client.getSalary().compareTo(cards.getIncome()) == 0){
            return (List<Card>) convertDTO.convertObjectList(this.cardRepository.findAll(), Card.class);
        }
        else if (client.getSalary().compareTo(cards.getIncome()) == 1) {
            return (List<Card>) convertDTO.convertObjectList(this.cardRepository.findAll(), Card.class);
        }
        else {
            return (List<Card>) convertDTO.convertObjectList(this.cardRepository.findAll(), Card.class);
        }

    }
}
