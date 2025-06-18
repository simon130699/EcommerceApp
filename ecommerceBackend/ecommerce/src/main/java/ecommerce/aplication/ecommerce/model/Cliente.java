package ecommerce.aplication.ecommerce.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Setter @Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
private String name;
private String surname;
private String dni;
private String email;
private String tel;
private LocalDate dateOfbirdth;
private LocalDate dateOfRegistration;
private Boolean isActive;
//en direcciones va el objeto Direccion
//private List<String> direcciones;
//en pedidos va el objeto pedido
//private List<String> pedidos;



    public Cliente(Long id, String name, String surname, String dni,String tel,LocalDate dateOfBirdth, LocalDate dateOfRegistration, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.tel=tel;
        this.dateOfbirdth=dateOfBirdth;
        this.dateOfRegistration=dateOfRegistration;
        this.isActive= isActive;
   
    }

    public Cliente() {
    }
}
