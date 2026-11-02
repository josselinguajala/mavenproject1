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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un pedido (factura) de Bamboosmile.
 * Relación OneToMany con DetalleFactura: una factura contiene muchos detalles.
 * Relación ManyToOne con Cliente: muchos pedidos pueden pertenecer a un mismo cliente.
 */
@Entity
@Table(name = "facturas")
   public class Factura{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double subtotal15; // Subtotal con IVA 15%

    @Column(nullable = false)
    private Double iva;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false)
    private Double valorTotal;

    // OneToMany bidireccional con DetalleFactura. mappedBy apunta al campo "factura" en DetalleFactura.
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFacturaa> detalles = new ArrayList<>();

    // ManyToOne con Cliente. La FK se crea en la tabla facturas.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client client;

    // Constructores, getters y setters
    public Factura() {}

    public Factura(LocalDate fecha, Client cliente) {
        this.fecha = fecha;
        this.client = cliente;
    }

    // Getters y setters omitidos

    public void setDetalles(List<DetalleFacturaa> detalles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDescuento(Double nuevoDescuento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Double getSubtotal15() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Double getIva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setValorTotal(double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}