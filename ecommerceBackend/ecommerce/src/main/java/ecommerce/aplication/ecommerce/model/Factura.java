package ecommerce.aplication.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // clave primaria autogenerada
    private Long id;
}
