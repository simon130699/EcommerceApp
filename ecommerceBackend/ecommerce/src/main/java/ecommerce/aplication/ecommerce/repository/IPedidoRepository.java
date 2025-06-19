package ecommerce.aplication.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.aplication.ecommerce.model.Pedido;
@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long> {
boolean existsByNumeroPedido(String numeroPedido);
}
