/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.DAO.ManagerDAOCine;
import com.cine.entidades.Actor;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author acardenas
 */
public class ManagerActor {
    
    ManagerDAOCine managerDAOCine = new ManagerDAOCine();
    
    public void insertarActor( Actor objActor ) throws Exception
    {
        managerDAOCine.insertar(objActor);
    }
    
    public List<Actor> buscarTodosActor() throws Exception
    {
        return managerDAOCine.findAll(Actor.class, "o.apellido DESC");
    }
    
    public Actor buscarActorById( BigDecimal idActor) throws Exception{
        return (Actor) managerDAOCine.findById(Actor.class, idActor);
    }
    
    public void actuaizarActos( Actor objActor ) throws Exception{
        managerDAOCine.actualizar(objActor);
    }
    
    public void eliminarActor( BigDecimal idActor ) throws Exception{
        managerDAOCine.eliminar(Actor.class, idActor);
    }
    
    
}
