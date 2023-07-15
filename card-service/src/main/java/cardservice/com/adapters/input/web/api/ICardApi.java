package cardservice.com.adapters.input.web.api;

import cardservice.com.adapters.input.web.api.request.CardRequest;
import cardservice.com.adapters.input.web.api.response.CardResponse;
import cardservice.com.adapters.input.web.api.request.UpdateCardRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("api/v1/cardservice")
public interface ICardApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CardResponse> createNewCard(@RequestBody CardRequest cardRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> listAllCards();

    // mudar para nome, tipo do cartao
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> findCardById(@RequestParam Long id);

    @PutMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> updateCardLimit(@RequestBody UpdateCardRequest updateCardRequest
                                                ,@RequestParam("id") Long id) ;

    @GetMapping("/findIncome")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> findByIncome(@RequestParam("incomeCard")BigDecimal incomeCard);

}
