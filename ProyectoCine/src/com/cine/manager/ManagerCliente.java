/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.DAO.ManagerDAOCine;
import com.cine.entidades.Cliente;
import java.util.List;

/**
 *
 * @author acardenas
 */
public class ManagerCliente {
    ManagerDAOCine managerDAOCine = new ManagerDAOCine();
    
    public void ingresarCliente(Cliente objCliente) throws Exception{
        managerDAOCine.insertar(objCliente);
    }
    
    public void editarCliente(Cliente objCliente) throws Exception{
        managerDAOCine.actualizar(objCliente);
    }
    
    public void eliminarCliente(String cedula ) throws Exception{
        managerDAOCine.eliminar(Cliente.class, cedula);
    }
    
    public List<Cliente> buscarTodosClientes() throws Exception{
        return managerDAOCine.findAll(Cliente.class, "o.apellidos ASC");
    }

    public Cliente buscarClienteByCedula(String cedula) throws Exception {
       return (Cliente) managerDAOCine.findById(Cliente.class, cedula);
    }
}
