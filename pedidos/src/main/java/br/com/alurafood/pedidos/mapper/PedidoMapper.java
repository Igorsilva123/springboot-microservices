package br.com.alurafood.pedidos.mapper;
import br.com.alurafood.pedidos.dto.PedidoDto;
import br.com.alurafood.pedidos.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PedidoMapper {




    @Mapping(target = "id", source = "id")
    @Mapping(target = "dataHora", source = "dataHora")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "itens", source = "itens")
    PedidoDto toDto(Pedido dto);


    Pedido toEntity(PedidoDto dto);

}
