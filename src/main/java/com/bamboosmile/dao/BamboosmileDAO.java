/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Josselin
 */
package com.bamboosmile.dao;

import com.productos.entities.*;
import jakarta.persistence.*;
import java.util.List;

public class BamboosmileDAO{

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public BamboosmileDAO() {
        emf = Persistence.createEntityManagerFactory("BamboosmilePU");
        em = emf.createEntityManager();
    }

    // --- CREATE: Registrar un nuevo pedido (Factura) con sus detalles ---
    public void crearPedido(Factura factura, List<DetalleFacturaa> detalles) {
        em.getTransaction().begin();
        factura.setDetalles(detalles);
        for (DetalleFacturaa d : detalles) {
            d.setFactura(factura);
        }
        em.persist(factura); // Persiste en cascada los detalles
        em.getTransaction().commit();
    }

    // --- READ: Consultar pedidos de un cliente usando JPQL ---
    public List<Factura> obtenerPedidosPorCliente(Long clienteId) {
        String jpql = "SELECT f FROM Factura f WHERE f.cliente.id = :clienteId";
        TypedQuery<Factura> query = em.createQuery(jpql, Factura.class);
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    // --- READ: Buscar productos por nombre con JPQL (LIKE) ---
    public List<Producto> buscarProductosPorNombre(String nombre) {
        String jpql = "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:nombre)";
        TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    // --- UPDATE: Actualizar el estado de un pedido (simulado con descuento) ---
    public void actualizarDescuentoPedido(Long facturaId, Double nuevoDescuento) {
        em.getTransaction().begin();
        Factura factura = em.find(Factura.class, facturaId);
        if (factura != null) {
            factura.setDescuento(nuevoDescuento);
            // Recalcular valorTotal
            factura.setValorTotal(factura.getSubtotal15() + factura.getIva() - nuevoDescuento);
            em.merge(factura);
        }
        em.getTransaction().commit();
    }

    // --- DELETE: Cancelar un pedido (eliminar Factura y sus detalles en cascada) ---
    public void cancelarPedido(Long facturaId) {
        em.getTransaction().begin();
        Factura factura = em.find(Factura.class, facturaId);
        if (factura != null) {
            em.remove(factura); // Elimina en cascada los DetalleFactura
        }
        em.getTransaction().commit();
    }

    // Cerrar recursos
    public void cerrar() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
    
        // --- CREATE: Inicializar catálogo de productos ---
    public void inicializarProductos() {
        em.getTransaction().begin();
        
        // Verificamos si la tabla ya tiene datos para no duplicar
        Long count = em.createQuery("SELECT COUNT(p) FROM Producto p", Long.class).getSingleResult();
        
        if (count == 0) {
            // Creamos los productos (asignando un stock por defecto, ej. 100 unidades)
            Producto p1 = new Producto("Refill de pasta 125 ml", 6.25, 100);
            Producto p2 = new Producto("Cepillo de bambu 10 000 cerdas", 6.25, 100);
            Producto p3 = new Producto("Cepillo dental de bambu kids", 6.25, 100);
            Producto p4 = new Producto("Cepillo dental de bambu normal", 6.25, 100);
            Producto p5 = new Producto("Pasta dental natural fresh", 8.52, 100);
            Producto p6 = new Producto("Pasta dental natural kids", 8.52, 100);

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);
            em.persist(p6);
            
            System.out.println("Catálogo de productos inicializado correctamente.");
        } else {
            System.out.println("El catálogo ya contiene productos. No se insertaron duplicados.");
        }
        
        em.getTransaction().commit();
    }
    
}
