/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.ITCliente;
import Pojo.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public class DaoTCliente implements ITCliente {
    
    @Override
    public Cliente getByIdCliente(Session session, Integer idCliente) throws Exception {
        return (Cliente) session.load(Cliente.class, idCliente);
    }

    @Override
    public Cliente getByCedula(Session session, String cedula) throws Exception {
        String hql = "from Cliente where cedula=:cedula";
        Query query = session.createQuery(hql);
        query.setParameter("cedular", cedula);

        return (Cliente) query.uniqueResult();
    }

    @Override
    public boolean insert(Session session, Cliente cliente) throws Exception {
        session.save(cliente);
        return true;
    }

    @Override
    public boolean update(Session session, Cliente cliente) throws Exception {
        session.update(cliente);
        return true;
    }

    @Override
    public boolean delete(Session session, Cliente cliente) throws Exception {
        session.delete(cliente);
        return true;
    }

    @Override
    public List<Cliente> getAll(Session session) throws Exception {
        return session.createCriteria(Cliente.class).list();
    }

}
