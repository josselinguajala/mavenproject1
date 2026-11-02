/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bamboosmile.dao;

/**
 *
 * @author Josselin
 */


import com.productos.entities.Producto;
import java.util.List;

   public class Main{
    public static void main(String[] args) {
        System.out.println("Iniciando conexión con la base de datos Bamboosmile...");
        
        // 1. Instanciamos el DAO (esto levanta JPA y crea las tablas en Postgres)
        BamboosmileDAO dao = new BamboosmileDAO();

        try {
            // 2. Insertamos los productos iniciales
            System.out.println("Cargando catálogo de productos...");
            dao.inicializarProductos();

            // 3. Consultamos los productos para verificar que se guardaron (Operación READ)
            System.out.println("\n--- Lista de Productos en la Base de Datos ---");
            // Suponiendo que tienes un método para listar todos, o usamos buscarProductosPorNombre con vacío
            List<Producto> productos = dao.buscarProductosPorNombre(""); 
            
            for (Producto p : productos) {
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Precio: $" + p.getPrecio());
            }

        } catch (Exception e) {
            System.err.println("Error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 4. Cerramos la conexión
            dao.cerrar();
            System.out.println("\nConexión cerrada. Proceso finalizado.");
        }
    }
}
