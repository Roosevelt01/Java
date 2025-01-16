package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        CrudRepositorio repo = new ClienteListRepositorio();
        
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "Gónzalez"));
        repo.crear(new Cliente("Luci", "Martínez"));
        repo.crear(new Cliente("Andrés", "Guzmán"));

        List<Cliente> clientes = repo.lista();
        clientes.forEach(System.out::println);

        System.out.println("\nPaginable");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("\nOrdenar");
        List<Cliente> clienteOrdenAsc = ((OrdenableRepositorio)repo).listar("apellido", Direccion.DESC);

        for(Cliente c: clienteOrdenAsc){
            System.out.println(c);
        }

        System.out.println("\nEditar");
        Cliente beaActualizar = new Cliente("Bea","Mena");
        beaActualizar.setId(2);
        repo.edtitar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        ((OrdenableRepositorio)repo).listar("apellido", Direccion.ASC).forEach(System.out::println);


        System.out.println("\nEliminar");
        repo.eliminar(2);
        repo.lista().forEach(System.out::println);


    }
}
