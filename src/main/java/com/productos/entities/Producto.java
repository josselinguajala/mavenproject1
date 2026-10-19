/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productos.entities;

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

@Entity
@Table (name="tb_producto")
@Getter @Setter @NoArgsConstructor
/**
 *
 * @author Josselin Guajala Gr1 Software
 */

    public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)   
    @Column (name="pr_id", nullable=false)
    private Integer id;
    
    @Column (name="pr_nombre", nullable=false)
    private String nombre;
    
    @Column (name="pr_cantidad")
    private Integer cantidad;
    
    @Column (name="pr_precio")
    private Double precio;
    
   

    public Producto(String nombre, Integer cantidad, Double precio) {
       this.nombre = nombre;
       this.cantidad = cantidad;
       this.precio = precio;
    }
    
    // Getters y Setters manuales
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
