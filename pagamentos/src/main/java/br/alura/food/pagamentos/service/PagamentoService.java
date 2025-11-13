package br.alura.food.pagamentos.service;

import br.alura.food.pagamentos.domain.Pagamento;
import br.alura.food.pagamentos.domain.Status;
import br.alura.food.pagamentos.dto.PagamentoRequestDto;
import br.alura.food.pagamentos.dto.PagamentoResponseDto;
import br.alura.food.pagamentos.mapper.PagamentoMapper;
import br.alura.food.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PagamentoMapper mapper;

    public Page<PagamentoResponseDto> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(mapper::toDTO);
    }

    public PagamentoResponseDto obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return mapper.toDTO(pagamento);
    }

    public PagamentoResponseDto criarPagamento(PagamentoRequestDto dto) {
        Pagamento pagamento = mapper.toEntity(dto);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return mapper.toDTO(pagamento);
    }

    public PagamentoResponseDto atualizarPagamento(Long id, PagamentoRequestDto dto) {
        Pagamento pagamento = mapper.toEntity(dto);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return mapper.toDTO(pagamento);
    }

    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }


}
