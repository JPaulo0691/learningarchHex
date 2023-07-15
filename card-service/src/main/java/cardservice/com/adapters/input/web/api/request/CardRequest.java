package cardservice.com.adapters.input.web.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardRequest {

    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;
}
