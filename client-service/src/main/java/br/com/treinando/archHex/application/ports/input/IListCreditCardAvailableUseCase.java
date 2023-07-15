package br.com.treinando.archHex.application.ports.input;

import cardservice.com.adapters.output.database.postgres.entity.Card;

import java.math.BigDecimal;
import java.util.List;

public interface IListCreditCardAvailableUseCase {

    List<Card> execute(String document, BigDecimal salary);
}
