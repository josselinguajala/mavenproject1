/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productos.entities;


import jakarta.persistence.*;
import java.util.List;
/**
 *
 * @author Josselin
 */
/**
 * Entidad que representa una categoría de productos (ej. Cepillos, Pastas).
 * Relación ManyToMany bidireccional con Producto.
 */
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación N:M (ManyToMany). El lado dueño es Producto, aquí solo mapeamos.
    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos;

    // Getters y Setters...
}
