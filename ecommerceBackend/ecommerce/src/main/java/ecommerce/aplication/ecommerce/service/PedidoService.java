package ecommerce.aplication.ecommerce.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.aplication.ecommerce.model.Pedido;
import ecommerce.aplication.ecommerce.repository.IPedidoRepository;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public Pedido crearPedido(Pedido pedido) {
        String numeroGenerado = generarNumeroPedidoUnico();
        pedido.setNumeroPedido(numeroGenerado);

        // Asignamos la fecha si aún no está seteada
        if (pedido.getFechaPedido() == null) {
            pedido.setFechaPedido(LocalDateTime.now());
        }

        // Guardamos en base de datos
        return pedidoRepository.save(pedido);
    }

    private String generarNumeroPedidoUnico() {
        String numero;
        //genera al menos un numero de pedido
        do {
            numero = "PED" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (pedidoRepository.existsByNumeroPedido(numero));
        return numero;
    }

}
