package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio, PaginableRepositorio{
    private List<Cliente> dataSource;

    @Override
    public List<Cliente> lista() {
        return this.dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;

        for(Cliente cli: dataSource){
            if(cli.getId().equals(id)){
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
        return List.of();
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return List.of();
    }
}
