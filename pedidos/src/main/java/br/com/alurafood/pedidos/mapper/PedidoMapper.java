package br.com.alurafood.pedidos.mapper;
import br.com.alurafood.pedidos.dto.PedidoDto;
import br.com.alurafood.pedidos.model.Pedido;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDto toDto(Pedido dto);


    Pedido toEntity(PedidoDto dto);

}
