/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.productos.mavenproject1;
import java.util.List;
import com.productos.entities.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Josselin Guajala Gr1 Nivel 3 Software
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        EntityManager manager = null;
        try(EntityManagerFactory emf=Persistence.createEntityManagerFactory("com.productos_mavenproject1_jar_1.0-SNAPSHOTPU"))
        {
           
            manager.getTransaction().begin();
            
            Producto pr1=new Producto ("Cepillo dental Premium 10 000 cerdas",100,6.5);
            manager.persist(pr1);
            
            Producto pr2=new Producto ("Cepillo dental kids",100,4.5);
            manager.persist(pr2);
            
            Producto pr3=new Producto ("Cepillo dental BambooEco",10,3.09);
            manager.persist(pr3);
        }


            Producto productoEncontrado = manager.find(Producto.class, 1);
            if (productoEncontrado != null) {
                System.out.println("(Por ID): " + productoEncontrado.getNombre() + " - Price: $" + productoEncontrado.getPrecio());
            }

            // Listar todos los productos usando JPQL
            List<Producto> listaProductos = manager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
            System.out.println(" Total registrados = " + listaProductos.size());



            // (Actualizar un registro)
            Producto productoAActualizar = manager.find(Producto.class, 1);
            if (productoAActualizar != null) {
                // Modificamos el objeto en memoria y JPA actualizará la BD al hacer commit
                productoAActualizar.setPrecio(7.25);
                productoAActualizar.setCantidad(120);
                System.out.println(" Producto ID"+Producto.class+" actualizado");
            }


    
            Producto productoAEliminar = manager.find(Producto.class, 3); // Borramos el producto con ID 
            if (productoAEliminar != null) {
                manager.remove(productoAEliminar);
                System.out.println(" Producto ID"+ Producto.class + " eliminado correctamente ");
            }

        } catch (Exception e) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (manager != null){
            manager.close();
            emf.close();
        }
        }
}