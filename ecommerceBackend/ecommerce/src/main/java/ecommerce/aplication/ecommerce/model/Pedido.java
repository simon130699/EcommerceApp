package ecommerce.aplication.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPedido;

    private String numeroPedido;
    private LocalDateTime fechaPedido;
    private BigDecimal total;
    private String estadoPendiente;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccionEnvio;

    //@ManyToOne
    //@JoinColumn(name = "metodo_pago_id")
    //private MetodoPago metodoDePago;

    //@OneToOne(cascade = CascadeType.ALL)
    //private Factura factura;

    //@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<ItemPedido> items = new ArrayList<>();

    public Pedido(String numeroPedido, LocalDateTime fechaPedido, BigDecimal total, String estadoPendiente,
                  String observaciones, Cliente cliente, Direccion direccionEnvio, MetodoPago metodoDePago) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estadoPendiente = estadoPendiente;
        this.observaciones = observaciones;
        this.cliente = cliente;
        this.direccionEnvio = direccionEnvio;
        //this.metodoDePago = metodoDePago;
    }

}

