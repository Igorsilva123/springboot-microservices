package br.alura.food.pagamentos.dto;


import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public record PagamentoRequestDto(
                        @NotNull
                        @Positive BigDecimal valor,
                        @NotBlank @Size(max = 100)
                        String nome,
                        @NotBlank
                        @Size(max = 19) String numero,
                        @NotBlank
                        @Size(max = 7)
                        String expiracao,
                        @NotBlank
                        @Size(min = 3, max = 7)
                        String codigo,
                        @NotNull
                        Long pedidoId,
                        @NotNull
                        Long formaDePagamentoId) {

}
