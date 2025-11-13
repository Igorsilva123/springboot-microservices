package br.com.alurafood.pedidos.service;

import br.com.alurafood.pedidos.dto.PedidoDto;
import br.com.alurafood.pedidos.dto.StatusDto;
import br.com.alurafood.pedidos.mapper.PedidoMapper;
import br.com.alurafood.pedidos.model.Pedido;
import br.com.alurafood.pedidos.model.Status;
import br.com.alurafood.pedidos.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoMapper pedidoMapper;


    public List<PedidoDto> obterTodos() {
        return repository.findAll()
                .stream()
                .map(pedidoMapper::toDto).toList();

    }

    public PedidoDto obterPorId(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return pedidoMapper.toDto(pedido);
    }

    public PedidoDto criarPedido(PedidoDto dto) {
        Pedido pedido = pedidoMapper.toEntity(dto);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Status.REALIZADO);
        pedido.getItens().forEach(item -> item.setPedido(pedido));

        Pedido salvo = repository.save(pedido);
        return pedidoMapper.toDto(salvo);
    }

    public PedidoDto atualizaStatus(Long id, StatusDto dto) {
        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new EntityNotFoundException();
        }

        pedido.setStatus(dto.getStatus());
        repository.atualizaStatus(dto.getStatus(), pedido);
        return pedidoMapper.toDto(pedido);
    }

    public void aprovaPagamentoPedido(Long id) {
        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new EntityNotFoundException();
        }

        pedido.setStatus(Status.PAGO);
        repository.atualizaStatus(Status.PAGO, pedido);
    }
}
