/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author acardenas
 */
public class ManagerDAOCine {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public ManagerDAOCine() {
     crearEntityManager();
    }
    
    private EntityManager crearEntityManager()
    {
        emf = Persistence.createEntityManagerFactory("ProyectoCinePU");//nombre de la persistencia a utilizar
        em = emf.createEntityManager();
    return em;
    }
    
    public void insertar(Object pObjeto) throws Exception {
		if (pObjeto == null)
			throw new Exception("No se puede insertar un objeto null.");
		try {
                    EntityManager em = crearEntityManager();
                    EntityTransaction etx = em.getTransaction();
                        etx.begin();
                        em.persist(pObjeto);
                        etx.commit();
                        System.out.println("INSERTO...!!!!");
		} catch (Exception e) {
			throw new Exception("No se pudo insertar el objeto especificado: " + e.getMessage());
		}

	}
    
    public List findAll(Class clase, String orderBy) throws Exception {
        Query q;
        List listado;
        String sentenciaSQL;
        
        if(orderBy==null || orderBy.length()==0)
            sentenciaSQL="SELECT o FROM " + clase.getSimpleName() + " o";
        else
            sentenciaSQL="SELECT o FROM " + clase.getSimpleName() + " o ORDER BY "+orderBy;
        
        q=em.createQuery(sentenciaSQL);
        listado=q.getResultList();
        //mLog.MostrarLog(this.getClass(),"findAll",sentenciaSQL);
        return listado;
    }
    
    /* Finder genérico para buscar un objeto especifico.
	 * @param clase La clase sobre la que se desea consultar, ejemplo: Usuario.class
	 * @param pID Identificador (la clave primaria) que permitira la busqueda.
	 * @return El objeto solicitado (si existiera).
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object findById(Class clase,Object pID) throws Exception{
		if(pID==null)
			throw new Exception("Debe especificar el código para buscar el dato.");
		Object o;
		try {
			o = em.find(clase, pID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar la información especificada ("+pID+") : "+e.getMessage());
		}
		return o;
	}
        
       /* Actualiza la informaciÃ³n de un objeto en la persistencia.
	 * 
	 * @param pObjeto
	 *            Objeto que contiene la informaciÃ³n que se debe actualizar.
	 * @throws Exception
	 */
	public void actualizar(Object pObjeto) throws Exception {
		if (pObjeto == null)
			throw new Exception("No se puede actualizar un dato null");
		try {
                        em.getTransaction().begin();
                        em.merge(pObjeto);  
                        em.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("No se pudo actualizar el dato: " + e.getMessage());
		}

	}
        
         /**
	 * Elimina un objeto de la persistencia.
	 * 
	 * @param clase
	 *            La clase correspondiente al objeto que se desea eliminar.
	 * @param pID
	 *            El identificador del objeto que se desea eliminar.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void eliminar(Class clase, Object pID) throws Exception {
		if (pID == null) {
			// mostrarLog("Debe especificar un identificador para eliminar el
			// dato solicitado: "+clase.getSimpleName());
			throw new Exception("Debe especificar un identificador para eliminar el dato solicitado.");
		}
		Object o = findById(clase, pID);
		try {
                        em.getTransaction().begin();
			em.remove(o);
                        em.getTransaction().commit();
			// mostrarLog("Dato eliminado: "+clase.getSimpleName()+" "
			// +pID.toString());
		} catch (Exception e) {
			// mostrarLog("No se pudo eliminar el dato:
			// "+clase.getSimpleName());
			throw new Exception("No se pudo eliminar el dato (" + pID + ") : " + e.getMessage());
		}
	}
        
        public List findWhere(Class clase,String pClausulaWhere,String pOrderBy){
        //mostrarLog("findAll(where): "+clase.getSimpleName());
        Query q;
        List listado;
        String sentenciaSQL;

        if(pOrderBy==null||pOrderBy.length()==0)
            sentenciaSQL="SELECT o FROM " + clase.getSimpleName() + " o WHERE "+pClausulaWhere;
            
        else
            sentenciaSQL="SELECT o FROM " + clase.getSimpleName() + " o WHERE "+pClausulaWhere+" ORDER BY "+pOrderBy;
            System.out.println(sentenciaSQL);
        q=em.createQuery(sentenciaSQL);
        listado=q.getResultList();
        //managerLog.MostrarLog(this.getClass(),"findWhere",sentenciaSQL);
        return listado;
    }
    
}
