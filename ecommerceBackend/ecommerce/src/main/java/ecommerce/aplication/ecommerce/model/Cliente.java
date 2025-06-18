package ecommerce.aplication.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
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

      public Cliente(Long id, String nombre, String surnombre, String dni, String tel,
                   LocalDate fechaDeNacimiento, LocalDate fechaDeRegristro, Boolean isActive,
                   List<Direccion> direcciones, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.nombre = surnombre;
        this.dni = dni;
        this.tel = tel;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeRegristro = fechaDeRegristro;
        this.isActive = isActive;
        this.direcciones = direcciones != null ? direcciones : new ArrayList<>();
        this.pedidos = pedidos != null ? pedidos : new ArrayList<>();
    }

    public Cliente() {
    }
}
