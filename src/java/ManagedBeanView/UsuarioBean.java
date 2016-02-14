package ManagedBeanView;

import Dao.Encriptar;
import Interface.UsuarioDao;
import Dao.UsuarioDaoImpl;
import HibernateUtil.HibernateUtil;
import Pojo.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Named(value = "mbUsuario")
@RequestScoped

public class UsuarioBean {

    Session session;
    Transaction transaction;
    private Usuario usuario;
    private List<Usuario> usuarios;
   /* 

    public UsuarioBean() {
        usuario=new Usuario();
        usuarios=new ArrayList<Usuario>();
    }*/

    
  @PostConstruct
public void init() {
   usuario=new Usuario();
      usuarios=new ArrayList<Usuario>();
}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<Usuario> getUsuarios() {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuarios = usuarioDao.buscarTodos();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuario getSelected() {
        if (usuario == null) {
            usuario = new Usuario();

        }
        return usuario;
    }
    
    public void guardarUsuario() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            UsuarioDaoImpl daoTUsuario = new UsuarioDaoImpl();

            this.transaction = this.session.beginTransaction();
            this.usuario.setPassword(Encriptar.Encriptar(this.usuario.getPassword()));
            
          
            daoTUsuario.insert(this.session, this.usuario);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Ingresado Correctamente", ""));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();

    }
 
    public void actualizarUsuario() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            UsuarioDaoImpl daoTUsuario = new UsuarioDaoImpl();

            this.transaction = this.session.beginTransaction();
            this.usuario.setPassword(Encriptar.Encriptar(this.usuario.getPassword()));

            daoTUsuario.update(this.session, this.usuario);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Actualizado Correctamente", ""));

        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();

    }

    public void eliminarUsuario() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            UsuarioDaoImpl daoTUsuario = new UsuarioDaoImpl();

            this.transaction = this.session.beginTransaction();

            daoTUsuario.delete(this.session, this.usuario);

            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado Correctamente", ""));

        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiar();

    }

    public void limpiar() {
        usuario = new Usuario();
    }
    
    

}
