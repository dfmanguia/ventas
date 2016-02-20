/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeanView;

import Dao.DaoTProducto;
import HibernateUtil.HibernateUtil;
import Pojo.Tproducto;
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
@Named(value = "mbProducto")
@RequestScoped
public class MbProducto {

    Session session;
    Transaction transaction;
    /**
     * Creates a new instance of MbProducto
     */
    private Tproducto producto;

    public Tproducto getProducto() {
        return producto;
    }

    public Tproducto getSelected() {
        if (producto == null) {
            producto = new Tproducto();

        }
        return producto;
    }

    public void setProducto(Tproducto producto) {
        this.producto = producto;
    }

    public void guardarProducto() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTProducto daoTProducto = new DaoTProducto();

            this.transaction = this.session.beginTransaction();

            daoTProducto.insert(this.session, this.producto);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto agregado correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarProducto() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTProducto daoTProducto = new DaoTProducto();

            this.transaction = this.session.beginTransaction();

            daoTProducto.update(this.session, this.producto);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto actualizado correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProducto() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTProducto daoTProducto = new DaoTProducto();

            this.transaction = this.session.beginTransaction();

            daoTProducto.delete(this.session, this.producto);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto eliminado correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
