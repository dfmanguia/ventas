/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Diegg
 */
import Interface.ITOpcion;
import Pojo.Opcion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public class DaoTOpcion implements ITOpcion {
    
    @Override
    public Opcion getByIdOpcion(Session session, Integer idCliente) throws Exception {
        return (Opcion) session.load(Opcion.class, idCliente);
    }

    @Override
    public Opcion getByCedula(Session session, String cedula) throws Exception {
        String hql = "from Cliente where cedula=:cedula";
        Query query = session.createQuery(hql);
        query.setParameter("cedular", cedula);

        return (Opcion) query.uniqueResult();
    }

    @Override
    public boolean insert(Session session, Opcion opcion) throws Exception {
        session.save(opcion);
        return true;
    }

    @Override
    public boolean update(Session session, Opcion opcion) throws Exception {
        session.update(opcion);
        return true;
    }

    @Override
    public boolean delete(Session session, Opcion opcion) throws Exception {
        session.delete(opcion);
        return true;
    }

    @Override
    public List<Opcion> getAll(Session session) throws Exception {
        return session.createCriteria(Opcion.class).list();
    }

}
