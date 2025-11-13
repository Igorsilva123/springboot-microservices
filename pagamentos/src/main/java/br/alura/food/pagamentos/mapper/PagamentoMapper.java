package br.alura.food.pagamentos.mapper;

import br.alura.food.pagamentos.domain.Pagamento;
import br.alura.food.pagamentos.dto.PagamentoRequestDto;
import br.alura.food.pagamentos.dto.PagamentoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {


    PagamentoResponseDto toDTO(Pagamento dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    Pagamento toEntity(PagamentoRequestDto dto);
}