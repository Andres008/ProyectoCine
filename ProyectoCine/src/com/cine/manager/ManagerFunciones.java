/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.DAO.ManagerDAOCine;
import com.cine.entidades.Funciones;
import com.cine.utilitarios.Utilitarios;
import java.util.Date;
import java.util.List;

/**
 *
 * @author acardenas
 */
public class ManagerFunciones {
    ManagerDAOCine managerDaoCine = new ManagerDAOCine();

    public List<Funciones> buscarTodasFunciones() throws Exception {
        return managerDaoCine.findAll(Funciones.class, "o.fecha ASC");
        }

    public List<Funciones> buscarFuncionesATiempo() {
        Utilitarios util = new Utilitarios();
        return managerDaoCine.findWhere(Funciones.class, "o.fecha >= to_date('"+util.cambiarDateString(new Date())+"','dd-MM-yyyy')" ,"o.fecha ASC");
    }
}
