package cardservice.com.adapters.input.web.controller;

import cardservice.com.adapters.input.web.api.request.CardRequest;
import cardservice.com.adapters.input.web.api.request.UpdateCardRequest;
import cardservice.com.adapters.input.web.api.response.CardResponse;
import cardservice.com.adapters.input.web.api.ICardApi;
import cardservice.com.application.domain.CardDomain;
import cardservice.com.application.mapper.ConvertDTO;
import cardservice.com.application.ports.input.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class CardController implements ICardApi {

    private final ICreateCardDomainUseCase  iCreateCardDomainUseCase;
    private final IListAllCardDomainUseCase iListAllCardDomainUseCase;
    private final IFindCardDomainbyIdUseCase iFindCardDomainbyIdUseCase;
    private final IUpdateCardLimitUseCase iUpdateCardLimitUseCase;
    private final IFindCardDomainByIncomeUseCase iFindCardDomainByIncomeUseCase;

    private final ConvertDTO convertDTO;

    @Override
    public ResponseEntity<CardResponse> createNewCard(CardRequest cardRequest) {

        var cardDomain   = (CardDomain)   convertDTO.convertObjects(cardRequest,CardDomain.class);
        var response = (CardResponse) convertDTO.convertObjects(this.iCreateCardDomainUseCase.execute(cardDomain)
                                                               , CardResponse.class);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<CardResponse>> listAllCards() {
        var response = (List<CardResponse>) convertDTO.convertObjectList(this.iListAllCardDomainUseCase.execute()
                                                                  , CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CardResponse> findCardById(Long id) {

        var response = (CardResponse) convertDTO.convertObjects(this.iFindCardDomainbyIdUseCase.execute(id)
                                                                , CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CardResponse> updateCardLimit(UpdateCardRequest updateCardRequest,Long id) {

        var cardDomain = (CardDomain) convertDTO.convertObjects(updateCardRequest
                                                                  ,CardDomain.class);

        var response = (CardResponse) convertDTO.convertObjects(this.iUpdateCardLimitUseCase.execute(cardDomain, id)
                                                                , CardResponse.class);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<CardResponse>> findByIncome(BigDecimal incomeCard) {

        var response = (List<CardResponse>) convertDTO.convertObjectList(this.iFindCardDomainByIncomeUseCase.execute(incomeCard)
                                                                 ,CardResponse.class);

        return ResponseEntity.ok(response);
    }

}
