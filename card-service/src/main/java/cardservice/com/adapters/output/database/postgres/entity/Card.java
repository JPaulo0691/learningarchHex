package cardservice.com.adapters.output.database.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;

}
