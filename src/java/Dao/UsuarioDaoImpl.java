package Dao;

import Interface.UsuarioDao;
import Pojo.Usuario;
import HibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select u from Usuario u where username=:user and password=:pass";
        Query query = session.createQuery(sql);
        query.setString("user", usuario.getUsername());
        query.setString("pass", usuario.getPassword());
        return (Usuario) query.uniqueResult();
    }

    @Override
    public List<Usuario> buscarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Usuario").list();
    }

    @Override
    public Usuario getByIdUsuario(Session session, Integer idUsuario) throws Exception {
        return (Usuario) session.load(Usuario.class, idUsuario);
    }



    @Override
    public boolean insert(Session session, Usuario usuario) throws Exception {
        session.save(usuario);

        return true;
    }

    @Override
    public boolean update(Session session, Usuario usuario) throws Exception {
      
        session.update(usuario);
        return true;
    }

    @Override
    public boolean delete(Session session, Usuario usuario) throws Exception {
        session.delete(usuario);
        return true;
    }
}
