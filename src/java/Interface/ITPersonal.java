package Interface;

import Pojo.Personal;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public interface ITPersonal {
      public Personal getById(Session session, Integer idProducto) throws Exception;
    public List<Personal> getAll(Session session) throws Exception;
    public Personal getByPersonal(Session session, String codigoBarras) throws Exception;
 public boolean insert(Session session, Personal tPersonal) throws Exception;
    public boolean update(Session session, Personal tPersonal) throws Exception;
    public boolean delete(Session session,Personal tPersonal) throws Exception;
}