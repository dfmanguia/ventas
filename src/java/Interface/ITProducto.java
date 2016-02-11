/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojo.Tproducto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public interface ITProducto {
      public Tproducto getByIdProducto(Session session, Integer idProducto) throws Exception;
    public List<Tproducto> getAll(Session session) throws Exception;
    public Tproducto getByCodigoBarras(Session session, String codigoBarras) throws Exception;
 public boolean insert(Session session, Tproducto tProducto) throws Exception;
    public boolean update(Session session, Tproducto tProducto) throws Exception;
    public boolean delete(Session session,Tproducto tProducto) throws Exception;
}
