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

/**
 * Entidad que representa las credenciales de acceso de un cliente.
 * La relación OneToOne con Cliente se define en la entidad Cliente (lado dueño).
 */
@Entity
@Table(name = "usuarios")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @Column(nullable = false, length = 100)
    private String clave;

    // Constructores, getters y setters
    public Usuario() {}

    public Usuario(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }

    // Getters y setters omitidos
}
