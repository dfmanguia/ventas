package Interface;

import Pojo.Usuario;
import java.util.List;
import org.hibernate.Session;

public interface UsuarioDao {

    public Usuario buscarPorUsuario(Usuario usuario);
     public List<Usuario> buscarTodos();
     
    public Usuario getByIdUsuario(Session session, Integer idUsuario) throws Exception;
    
    public boolean insert(Session session, Usuario usuario) throws Exception;
    public boolean update(Session session, Usuario usuario) throws Exception;
    public boolean delete(Session session,Usuario usuario) throws Exception;
}
