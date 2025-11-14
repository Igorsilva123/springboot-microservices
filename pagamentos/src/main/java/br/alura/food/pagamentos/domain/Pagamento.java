package br.alura.food.pagamentos.domain;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long pedidoId;
    private Long formaDePagamentoId;
}
