package br.alura.food.pagamentos.mapper;

import br.alura.food.pagamentos.domain.Pagamento;
import br.alura.food.pagamentos.dto.PagamentoRequestDto;
import br.alura.food.pagamentos.dto.PagamentoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "valor", source = "valor")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "numero", source = "numero")
    @Mapping(target = "expiracao", source = "expiracao")
    @Mapping(target = "codigo", source = "codigo")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "pedidoId", source = "pedidoId")
    @Mapping(target = "formaDePagamentoId", source = "formaDePagamentoId")
    PagamentoResponseDto toDTO(Pagamento dto);


    Pagamento toEntity(PagamentoRequestDto dto);
}
