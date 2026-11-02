/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productos.entities;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
/**import javax.persistence.Entity;**/
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Entidad que representa un producto (cepillo dental) en el catálogo de Bamboosmile.
 * Relación OneToMany con DetalleFactura: un producto puede aparecer en muchos detalles de pedido.
 */
@Entity
@Table (name="tb_producto")
@Getter @Setter @NoArgsConstructor
/**
 *
 * @author Josselin Guajala Gr1 Software
 */

public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación de ID autoincremental
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer cantidad; // Stock disponible

    // Relación bidireccional OneToMany. mappedBy indica que la FK está en DetalleFactura.
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFacturaa> detalles = new ArrayList<>();

    // Constructores, getters y setters
    public Producto() {}

    public Producto(String nombre, Double precio, Integer cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y setters omitidos por brevedad

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPrecio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}