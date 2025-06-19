package ecommerce.aplication.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    
   
}
