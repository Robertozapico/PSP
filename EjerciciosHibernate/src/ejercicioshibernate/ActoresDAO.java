/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioshibernate;

import java.util.List;
import modelo.Actor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alumnop
 */
public class ActoresDAO {
    private Session sesion; 
    private Transaction tx;  

    public long guardaActor(Actor actor) throws HibernateException 
    { 
        short id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Short) sesion.save(actor); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return id; 
    }  

    public void actualizaActor(Actor actor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(actor); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public void eliminaActor(Actor actor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(actor); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public Actor obtenActor(short idContacto) throws HibernateException 
    { 
        Actor actor = null;  
        try 
        { 
            iniciaOperacion(); 
            actor = (Actor) sesion.get(Actor.class, idContacto); 
        } finally 
        { 
            sesion.close(); 
        }  

        return actor; 
    }  

    public List<Actor> obtenListaActor() throws HibernateException 
    { 
        List<Actor> listaActores = null;  

        try 
        { 
            iniciaOperacion(); 
            listaActores = sesion.createQuery("from Actor").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaActores; 
    }  

    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  

    private void manejaExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 

}
