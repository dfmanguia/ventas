/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeanView;

import Dao.DaoTPersonal;
import HibernateUtil.HibernateUtil;
import Pojo.Personal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.context.RequestContext;
/**
 *
 * @author Diegg
 */
@Named(value = "mbPersonal")
@RequestScoped
public class MbPersonal {

    Session session;
    Transaction transaction;
    /**
     * Creates a new instance of MbProducto
     */
    private Personal persona;
 private List<Personal> listaPer;
    public Personal getPersonal() {
        return persona;
    }
public Personal getSelected() {
        if (persona == null) {
            persona = new Personal();
            
        }
        return persona;
    }

    public void setPersonal(Personal persona) {
        this.persona = persona;
    }

    public void guardarPersonal() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPersonal daoTProducto = new DaoTPersonal();

            this.transaction = this.session.beginTransaction();

            daoTProducto.insert(this.session, this.persona);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Personal Ingresado correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarPersonal() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPersonal daoTProducto = new DaoTPersonal();

            this.transaction = this.session.beginTransaction();

            daoTProducto.update(this.session, this.persona);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Personal actualizado correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void eliminarPersonal() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPersonal daoTProducto = new DaoTPersonal();

            this.transaction = this.session.beginTransaction();

            daoTProducto.delete(this.session, this.persona);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Personal eliminado correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public List<Personal> getAllPer()
    {
        this.session=null;
        this.transaction=null;
        
        try
        {
            this.session=HibernateUtil.getSessionFactory().openSession();
            
            DaoTPersonal daoTPer=new DaoTPersonal();
            
            this.transaction=this.session.beginTransaction();
            
            this.listaPer=daoTPer.getAll(this.session);
            
            this.transaction.commit();
            
            return this.listaPer;
        }
        catch(Exception ex)
        {
            if(this.transaction!=null)
            {
                transaction.rollback();
            }
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
            
            return null;
        }
        finally
        {
            if(this.session!=null)
            {
                this.session.close();
            }
        }
    }
}


