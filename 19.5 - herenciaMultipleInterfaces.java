package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();

        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "Gónzalez"));
        repo.crear(new Cliente("Luci", "Martínez"));
        repo.crear(new Cliente("Andrés", "Guzmán"));

        List<Cliente> clientes = repo.lista();
        clientes.forEach(System.out::println);

        System.out.println("\nPaginable");
        List<Cliente> paginable = repo.listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("\nOrdenar");
        List<Cliente> clienteOrdenAsc = repo.listar("apellido", Direccion.DESC);

        for(Cliente c: clienteOrdenAsc){
            System.out.println(c);
        }

        System.out.println("\nEditar");
        Cliente beaActualizar = new Cliente("Bea","Mena");
        beaActualizar.setId(2);
        repo.edtitar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        repo.listar("apellido", Direccion.ASC).forEach(System.out::println);

        System.out.println("\nEliminar");
        repo.eliminar(2);
        repo.lista().forEach(System.out::println);
    }
}

package org.aguzman.poointerfaces.repositorio;

public interface ContableRepositorio {
    int total();
}

package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{
    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> lista() {
        return this.dataSource;
    }


    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;

        for(Cliente cli: dataSource){
            if(cli.getId() !=null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void edtitar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        this.dataSource.remove(c);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {

                    int resultado = 0;

                    if(dir == Direccion.ASC){
                            resultado = this.ordenar(a,b);
                    }else if(dir == Direccion.DESC){
                        resultado = this.ordenar(b,a);

                    }
                    return resultado;
            }

            private int ordenar(Cliente a, Cliente b){
                int resultado = 0 ;
                switch (campo){
                    case "id" ->
                            resultado = a.getId().compareTo(b.getId());
                    case "nombre" ->
                            resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" ->
                            resultado = a.getApellido().compareTo(b.getApellido());
                }
                return resultado;
            }
        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}


