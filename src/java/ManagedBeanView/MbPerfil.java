/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeanView;

import Dao.DaoTPerfil;
import HibernateUtil.HibernateUtil;
import Pojo.Perfil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

@Named(value = "mbPerfil")
@RequestScoped

public class MbPerfil {

    Session session;
    Transaction transaction;
    private Perfil perfil;
    private List<Perfil> listaPerfil;

    public Perfil getPerfil() {
        return perfil;
    }

    public Perfil getSelected() {
        if (perfil == null) {
            perfil = new Perfil();

        }
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void guardarPerfil() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPerfil daoTPerfil = new DaoTPerfil();

            this.transaction = this.session.beginTransaction();

            daoTPerfil.insert(this.session, this.perfil);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Perfil Ingresado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();

    }

    public void actualizarPerfil() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPerfil daoTPerfil = new DaoTPerfil();

            this.transaction = this.session.beginTransaction();

            daoTPerfil.update(this.session, this.perfil);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Perfil Actualizado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();

    }

    public void eliminarPerfil() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPerfil daoTPerfil = new DaoTPerfil();

            this.transaction = this.session.beginTransaction();

            daoTPerfil.delete(this.session, this.perfil);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Perfil Eliminado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

        } catch (Exception ex) {
            Logger.getLogger(MbPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiar();

    }

    public void limpiar() {
        perfil = new Perfil();
    }

    public List<Perfil> getAllPerfil() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTPerfil daoperfil = new DaoTPerfil();

            this.transaction = this.session.beginTransaction();

            this.listaPerfil = daoperfil.getAll(this.session);

            this.transaction.commit();

            return this.listaPerfil;
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
