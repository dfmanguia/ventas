/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeanView;

import Dao.DaoTCliente;
import HibernateUtil.HibernateUtil;
import Pojo.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTCliente daoTCliente = new DaoTCliente();

            this.transaction = this.session.beginTransaction();

            daoTCliente.insert(this.session, this.cliente);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Ingresado Correctamente", ""));
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
            this.session = HibernateUtil.getSessionFactory().openSession();

            DaoTCliente daoTCliente = new DaoTCliente();

            this.transaction = this.session.beginTransaction();

            daoTCliente.update(this.session, this.cliente);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Actualizado Correctamente", ""));

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

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Eliminado Correctamente", ""));

        } catch (Exception ex) {
            Logger.getLogger(MbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiar();

    }

    public void limpiar() {
        cliente = new Cliente();
    }
    
     public List<Cliente> getAllCliente()
    {
        this.session=null;
        this.transaction=null;
        
        try
        {
            this.session=HibernateUtil.getSessionFactory().openSession();
            
            DaoTCliente daocliente=new DaoTCliente();
            
            this.transaction=this.session.beginTransaction();
            
            this.listaCliente=daocliente.getAll(this.session);
            
            this.transaction.commit();
            
            return this.listaCliente;
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
