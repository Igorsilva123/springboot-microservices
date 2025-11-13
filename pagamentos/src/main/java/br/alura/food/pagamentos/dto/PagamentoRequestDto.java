package br.alura.food.pagamentos.dto;

import br.alura.food.pagamentos.domain.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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
