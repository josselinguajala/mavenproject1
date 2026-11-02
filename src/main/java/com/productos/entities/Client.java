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
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa a un cliente de Bamboosmile.
 * Relación OneToMany con Factura: un cliente puede tener muchos pedidos.
 * Relación OneToOne con Usuario: cada cliente tiene una cuenta de usuario asociada.
 */
@Entity
@Table(name = "clientes")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, unique = true, length = 20)
    private String cedula;

    // OneToMany bidireccional con Factura.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturas = new ArrayList<>();

    // OneToOne unidireccional con Usuario. La FK se crea en la tabla clientes.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", unique = true)
    private Usuario usuario;

    // Constructores, getters y setters
    public Client() {}

    public Client(String nombre, String correo, String telefono, String cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    // Getters y setters omitidos
}