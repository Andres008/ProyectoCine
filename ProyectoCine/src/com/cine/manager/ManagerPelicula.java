/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.DAO.ManagerDAOCine;
import com.cine.entidades.Peliculas;
import com.cine.entidades.TipoPelicula;
import java.util.List;

/**
 *
 * @author acardenas
 */
public class ManagerPelicula {
    ManagerDAOCine managerDaoCine = new ManagerDAOCine();

    public List<TipoPelicula> buscarTodosTipoPelicula() throws Exception {
     return managerDaoCine.findAll(TipoPelicula.class, "o.tipo");
    }

    public void ingresarPelicula(Peliculas objPelicula) throws Exception {
        managerDaoCine.insertar(objPelicula);
    }
    
    
}
