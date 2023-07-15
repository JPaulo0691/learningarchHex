package br.com.treinando.archHex.adapters.input.web.api.response;

import cardservice.com.adapters.output.database.postgres.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableCardsForClientResponse {

    private String name;
    private List<Card> cards;
}
