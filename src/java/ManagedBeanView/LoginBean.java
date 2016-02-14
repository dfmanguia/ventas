package ManagedBeanView;

import Dao.Encriptar;
import Interface.UsuarioDao;
import Dao.UsuarioDaoImpl;
import Pojo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class LoginBean {

    private Usuario usuario;

    public LoginBean() {
    }

    public void login(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.usuario.setPassword(Encriptar.Encriptar(this.usuario.getPassword()));
        usuario = usuarioDao.buscarPorUsuario(usuario);

        if (usuario != null) {
            loggedIn = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "Usuario");
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
