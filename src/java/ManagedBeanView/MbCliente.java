/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeanView;

import Dao.DaoTCliente;
import Dao.Encriptar;
import HibernateUtil.HibernateUtil;
import Pojo.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Diegg
 */
@Named(value = "mbCliente")
@RequestScoped
public class MbCliente {

    Session session;
    Transaction transaction;
    /**
     * Creates a new instance of MbCliente
     */
    private Cliente cliente;
    private List<Cliente> listaCliente;

    public Cliente getCliente() {
        return cliente;
    }

    public Cliente getSelected() {
        if (cliente == null) {
            cliente = new Cliente();

        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void guardarCliente() {
        this.session = null;
        this.transaction = null;

        try {

            if (Encriptar.validadorDeCedula(this.cliente.getCedula())) {
                this.session = HibernateUtil.getSessionFactory().openSession();

                DaoTCliente daoTCliente = new DaoTCliente();

                this.transaction = this.session.beginTransaction();

                daoTCliente.insert(this.session, this.cliente);

                this.transaction.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Cliente agregado"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
                System.out.println("correcto");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cédula es incorrecta"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
                System.out.println("incorrecto");

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();

    }

    public void actualizarCliente() {
        this.session = null;
        this.transaction = null;

        try {
            if (Encriptar.validadorDeCedula(this.cliente.getCedula())) {
                this.session = HibernateUtil.getSessionFactory().openSession();

                DaoTCliente daoTCliente = new DaoTCliente();

                this.transaction = this.session.beginTransaction();

                daoTCliente.update(this.session, this.cliente);

                this.transaction.commit();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Actualizado Correctamente"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cédula es incorrecta"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
                System.out.println("incorrecto");

            }

        } catch (Exception ex) {
            Logger.getLogger(MbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();

    }

    public void eliminarCliente() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTCliente daoTCliente = new DaoTCliente();

            this.transaction = this.session.beginTransaction();

            daoTCliente.delete(this.session, this.cliente);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Eliminado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        } catch (Exception ex) {
            Logger.getLogger(MbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiar();

    }

    public void limpiar() {
        cliente = new Cliente();
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Campos limpiados"));
        //RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
    }

    public List<Cliente> getAllCliente() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTCliente daocliente = new DaoTCliente();

            this.transaction = this.session.beginTransaction();

            this.listaCliente = daocliente.getAll(this.session);

            this.transaction.commit();

            return this.listaCliente;
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
