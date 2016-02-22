package ManagedBeanView;

import Dao.Encriptar;
import Interface.UsuarioDao;
import Dao.UsuarioDaoImpl;
import HibernateUtil.HibernateUtil;
import Pojo.Perfil;
import Pojo.Personal;
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
        Boolean aux = true;
        try {

            for (int i = 0; i < usuarios.size(); i++) {
                if (this.usuario.getPersonal().getPerId() == usuarios.get(i).getPersonal().getPerId()) {
                    aux = false;

                }
            }

            if (aux) {
                this.session = HibernateUtil.getSessionFactory().openSession();

                UsuarioDaoImpl daoTUsuario = new UsuarioDaoImpl();

                this.transaction = this.session.beginTransaction();
                this.usuario.setPassword(Encriptar.Encriptar(this.usuario.getPassword()));

                daoTUsuario.insert(this.session, this.usuario);

                this.transaction.commit();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Ingresado Correctamente"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Personal ya tiene usuario registrado"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();

    }

    public void actualizarcontra() {

        

        this.session = null;
        this.transaction = null;

        int a = 0;
        for (int i = 0; i < usuarios.size(); i++) {
            if (this.usuario.getId() == usuarios.get(i).getId()) {
                a = i;
            }
        }
        this.session = HibernateUtil.getSessionFactory().openSession();

                UsuarioDaoImpl daoTUsuario = new UsuarioDaoImpl();

                this.transaction = this.session.beginTransaction();
                
        this.usuario.setUsername(usuarios.get(a).getUsername());
        this.usuario.setPerfil(new Perfil(usuarios.get(a).getPerfil().getId()));
        this.usuario.setPersonal(new Personal(usuarios.get(a).getPersonal().getPerId()));
        this.usuario.setPassword(Encriptar.Encriptar(this.usuario.getPassword()));
System.out.println(""+this.usuario.getUsername()+"sa"+this.usuario.getPerfil().getId()+"per;"+this.usuario.getPersonal().getPerId());
System.out.println("holdsaaa" + this.usuario.getId() + " sdffsdsfsfd: " + this.usuario.getPassword());
        try {
            daoTUsuario.update(this.session, this.usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

                this.transaction.commit();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Actualizado Correctamente"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");
        
    }

    public void actualizarUsuario() {

        System.out.println("holdsaaa" + this.usuario.getId() + " " + this.usuario.getPassword());
        this.session = null;
        this.transaction = null;

        Boolean aux = true;

        Integer a = 0;
        try {

            for (int i = 0; i < usuarios.size(); i++) {
                if (this.usuario.getPersonal().getPerId() == usuarios.get(i).getPersonal().getPerId()) {
                    if (this.usuario.getId() == usuarios.get(i).getId()) {
                        aux = true;
                    } else {
                        aux = false;
                    }

                }
            }

            if (aux) {

                this.session = HibernateUtil.getSessionFactory().openSession();

                UsuarioDaoImpl daoTUsuario = new UsuarioDaoImpl();

                this.transaction = this.session.beginTransaction();
               
                this.usuario.setPassword(Encriptar.Encriptar(this.usuario.getPassword()));

                daoTUsuario.update(this.session, this.usuario);

                this.transaction.commit();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Actualizado Correctamente"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Personal ya tiene usuario registrado"));
                RequestContext.getCurrentInstance().update("frmprincipal:mensajeGeneral");

            }

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
