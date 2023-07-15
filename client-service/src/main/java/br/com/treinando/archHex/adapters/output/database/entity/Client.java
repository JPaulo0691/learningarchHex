package br.com.treinando.archHex.adapters.output.database.entity;

import cardservice.com.adapters.output.database.postgres.entity.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private BigDecimal salary;
    @OneToMany(mappedBy = "client_id", fetch = FetchType.LAZY, targetEntity = Card.class)
    private List<Card> cards;
}
