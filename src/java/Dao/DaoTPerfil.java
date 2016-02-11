/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.ITPerfil;
import Pojo.Perfil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public class DaoTPerfil implements ITPerfil {
    
    @Override
    public Perfil getByIdPerfil(Session session, Integer idCliente) throws Exception {
        return (Perfil) session.load(Perfil.class, idCliente);
    }

    @Override
    public Perfil getByCedula(Session session, String cedula) throws Exception {
        String hql = "from Cliente where cedula=:cedula";
        Query query = session.createQuery(hql);
        query.setParameter("cedular", cedula);

        return (Perfil) query.uniqueResult();
    }

    @Override
    public boolean insert(Session session, Perfil perfil) throws Exception {
        session.save(perfil);
        return true;
    }

    @Override
    public boolean update(Session session, Perfil perfil) throws Exception {
        session.update(perfil);
        return true;
    }

    @Override
    public boolean delete(Session session, Perfil perfil) throws Exception {
        session.delete(perfil);
        return true;
    }

    @Override
    public List<Perfil> getAll(Session session) throws Exception {
        return session.createCriteria(Perfil.class).list();
    }

}

