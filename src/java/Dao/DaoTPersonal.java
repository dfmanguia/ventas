/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Interface.ITPersonal;
import Pojo.Personal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Diegg
 */
public class DaoTPersonal implements ITPersonal
{
    
    @Override
    public Personal getById(Session session, Integer idProducto) throws Exception {
        return (Personal) session.load(Personal.class, idProducto);
    }

    @Override
    public List<Personal> getAll(Session session) throws Exception {
        return session.createCriteria(Personal.class).list();
    }

    @Override
    public Personal getByPersonal(Session session, String codigoBarras) throws Exception {
        String hql="from Tproducto where codigoBarras=:codigoBarras";
        Query query=session.createQuery(hql);
        query.setParameter("codigoBarras", codigoBarras);
        
        return (Personal) query.uniqueResult();
    }
    
     @Override
    public boolean insert(Session session, Personal tPersonal) throws Exception {
        session.save(tPersonal);
        
        return true;
    }
@Override
    public boolean update(Session session, Personal tPersonal) throws Exception {
        session.update(tPersonal);
        
        return true;
    }

    @Override
    public boolean delete(Session session, Personal tPersonal) throws Exception {
        session.delete(tPersonal);
        return true;
        
    }
    
    
}
