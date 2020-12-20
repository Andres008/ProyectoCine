/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.DAO.ManagerDAOCine;
import com.cine.entidades.ReservarFuncion;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author acardenas
 */
public class ManagerReservaFuncion {

    
    ManagerDAOCine managerDaoCine = new ManagerDAOCine();

    public  List<ReservarFuncion> buscarReservasByFuncion(BigDecimal id) {
        return managerDaoCine.findWhere(ReservarFuncion.class, "o.idFuncion.id="+id, null);
    }
    public void insertarReservaFuncion(ReservarFuncion reservaFun) throws Exception {
    managerDaoCine.insertar(reservaFun);
    }
}
