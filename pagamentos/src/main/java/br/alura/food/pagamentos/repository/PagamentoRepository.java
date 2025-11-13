package br.alura.food.pagamentos.repository;

import br.alura.food.pagamentos.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
