package br.com.treinando.archHex.application.usecase;

import br.com.treinando.archHex.application.domain.entity.ClientDomain;
import br.com.treinando.archHex.application.ports.input.IListCreditCardAvailableUseCase;
import br.com.treinando.archHex.application.ports.output.IListCreditCardAvailableDomainRepository;
import cardservice.com.adapters.output.database.postgres.entity.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ListAvailableCreditCardsUseCase implements IListCreditCardAvailableUseCase {

    private final IListCreditCardAvailableDomainRepository iListCreditCardAvailableDomainRepository;

    @Override
    public List<Card> execute(String document, BigDecimal salary) {

        return ClientDomain.builder()
                           .document(document)
                           .salary(salary)
                           .build()
                           .availableCreditCardsForClient(iListCreditCardAvailableDomainRepository);
    }
}
