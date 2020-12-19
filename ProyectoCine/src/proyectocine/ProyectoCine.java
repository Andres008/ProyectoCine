/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocine;

import com.cine.entidades.Actor;
import com.cine.manager.ManagerActor;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acardenas
 */
public class ProyectoCine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ManagerActor managerActor = new ManagerActor();
            /*Actor objActor = new Actor();
            objActor.setApellido("Perez");
            objActor.setNombre("Andres");
            objActor.setPais("Ecuador");
            managerActor.insertarAutor(objActor);*/
            /*managerActor.buscarTodosActor().forEach(actor->{
                System.out.println(actor.getApellido());
            });*/
           /* Actor act = managerActor.buscarActorById(new BigDecimal(2));
            if (act==null)
                JOptionPane.showMessageDialog(null, "Valor no existe");
            else
            {
                act.setNombre("Pedro");
                act.setApellido("Arias");
                managerActor.actuaizarActos(act);
                System.out.println(act.getApellido()+", "+act.getNombre());
            }*/
           managerActor.buscarTodosActor().forEach(actor->{
                System.out.println(actor.getApellido());
            });
           managerActor.eliminarActor(new BigDecimal(2));
            System.out.println("Eliminados");
           managerActor.buscarTodosActor().forEach(actor->{
                System.out.println(actor.getApellido());
            });
                
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ProyectoCine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
