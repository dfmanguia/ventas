/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeanView;

import Dao.DaoTOpcion;
import HibernateUtil.HibernateUtil;
import Pojo.Opcion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Diegg
 */
@Named(value = "mbOpcion")
@RequestScoped
public class MbOpcion {

    /**
     * Creates a new instance of MbOpcion
     */
    public MbOpcion() {
    }
    Session session;
    Transaction transaction;
    private Opcion opcion;
    private List<Opcion> listaOpcion;

    public Opcion getOpcion() {
        return opcion;
    }

    public Opcion getSelected() {
        if (opcion == null) {
            opcion = new Opcion();

        }
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public void guardarOpcion() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTOpcion daoTOpcion = new DaoTOpcion();

            this.transaction = this.session.beginTransaction();

            daoTOpcion.insert(this.session, this.opcion);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Opcion Ingresado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();

    }

    public void actualizarOpcion() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTOpcion daoTOpcion = new DaoTOpcion();

            this.transaction = this.session.beginTransaction();

            daoTOpcion.update(this.session, this.opcion);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Opcion Actualizada Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

        } catch (Exception ex) {
            Logger.getLogger(MbOpcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();

    }

    public void eliminarOpcion() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTOpcion daoTOpcion = new DaoTOpcion();

            this.transaction = this.session.beginTransaction();

            daoTOpcion.delete(this.session, this.opcion);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Opcion Eliminada Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbOpcion.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiar();

    }

    public void limpiar() {
        opcion = new Opcion();
    }

    public List<Opcion> getAllOpcion() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTOpcion daoopcion = new DaoTOpcion();

            this.transaction = this.session.beginTransaction();

            this.listaOpcion = daoopcion.getAll(this.session);

            this.transaction.commit();

            return this.listaOpcion;
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
}
