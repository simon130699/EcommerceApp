package ecommerce.aplication.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String calle;
    private String numero;
    private String piso;
    private String dpto;
    private String ciudad;
    private String provincia;
    private String cp;
    private String pais;
    private Boolean esPrincipal;

     @ManyToOne
    private Cliente cliente;
    
     public Direccion(String calle, String numero, String ciudad, String provincia, String cp, Cliente cliente) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.cp = cp;
        this.cliente = cliente;
    }
}
