package br.alura.food.pagamentos.dto;

import br.alura.food.pagamentos.domain.Status;

import java.math.BigDecimal;

public record PagamentoResponseDto(
        Long id,
        BigDecimal valor,
        String nome,
        String numero,
        String expiracao,
        String codigo,
        Status status,
        Long pedidoId,
        Long formaDePagamentoId
) {}