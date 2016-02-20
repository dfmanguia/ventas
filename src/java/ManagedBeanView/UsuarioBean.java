package ManagedBeanView;

import Dao.Encriptar;
import Interface.UsuarioDao;
import Dao.UsuarioDaoImpl;
import HibernateUtil.HibernateUtil;
import Pojo.Usuario;
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

@Named(value = "mbUsuario")
@RequestScoped

public class UsuarioBean {

    Session session;
    Transaction transaction;
    private Usuario usuario;
    private List<Usuario> usuarios;

    
    public Usuario getUsuario() throws Exception {
       
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

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Ingresado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
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

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Actualizado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

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

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Eliminado Correctamente"));
            RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

        } catch (Exception ex) {
            Logger.getLogger(MbProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiar();

    }

    public void limpiar() {
        usuario = new Usuario();
    }

}
