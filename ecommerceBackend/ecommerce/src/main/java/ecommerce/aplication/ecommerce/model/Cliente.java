package ecommerce.aplication.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@NoArgsConstructor
//genera un constructor vacio requisito obligatorio por jpa
@AllArgsConstructor
//genera un constructor con todos los parametros
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
private String nombre;
private String apellido;
private String dni;
private String email;
private String tel;
private LocalDate fechaDeNacimiento;
private LocalDate fechaDeRegristro;
private Boolean isActive;

    @OneToMany
    private List<Direccion> direcciones = new ArrayList<>();

    @OneToMany
    private List<Pedido> pedidos = new ArrayList<>();

     // Devuelve el nombre completo 
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Agrega una dirección a la lista de direcciones
    public void agregarDireccion(Direccion direccion) {
        if (direccion != null) {

            this.direcciones.add(direccion);
        }
    }

    // Devuelve la dirección principal
    public Direccion getDireccionPrincipal() {
        if (direcciones.isEmpty()) {
            return null;
        }
        return direcciones.get(0);
    }

    // Suma el total de todos los pedidos asociados al cliente
    public BigDecimal calcularTotalCompras() {
        return pedidos.stream()
                .map(Pedido::getTotal)
                // toma cada pedido y obtiene su total (importe total de ese pedido).
                .filter(total -> total != null)
                //suma todos los valores del stream (totales de pedidos) comenzando desde cero.
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    // Activa el cliente
    public void activar() {
        this.isActive = true;
    }

    // Desactiva el cliente
    public void desactivar() {
        this.isActive = false;
    }
}
