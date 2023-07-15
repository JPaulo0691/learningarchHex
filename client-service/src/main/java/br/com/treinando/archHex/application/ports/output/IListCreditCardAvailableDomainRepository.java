package br.com.treinando.archHex.application.ports.output;

import cardservice.com.adapters.output.database.postgres.entity.Card;

import java.math.BigDecimal;
import java.util.List;

public interface IListCreditCardAvailableDomainRepository {

    List<Card> execute(String document, BigDecimal salary);
}


