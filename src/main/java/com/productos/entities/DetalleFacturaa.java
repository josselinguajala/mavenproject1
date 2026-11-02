/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productos.entities;

/**
 *
 * @author Josselin
 */
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
/**import javax.persistence.Entity;**/
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la línea de detalle de un pedido (factura).
 * Relación ManyToOne con Producto: muchos detalles pueden referenciar un mismo producto.
 * Relación ManyToOne con Factura: muchos detalles pertenecen a una misma factura.
 * Esta entidad es el "lado dueño" (owning side) de ambas relaciones.
 */
@Entity
@Table(name = "detalle_facturaa")
   public class DetalleFacturaa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    // ManyToOne con Producto. @JoinColumn define la FK en esta tabla.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    // ManyToOne con Factura. @JoinColumn define la FK en esta tabla.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;

    // Constructores, getters y setters
    public DetalleFacturaa() {}

    public DetalleFacturaa(Integer cantidad, Producto producto, Factura factura) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.factura = factura;
    }

    // Getters y setters omitidos

    public void setFactura(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}