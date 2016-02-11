/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.ITVenta;
import Pojo.Tventa;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public class DaoTVenta implements ITVenta
{

    @Override
    public boolean insert(Session session, Tventa tVenta) throws Exception {
        session.save(tVenta);
        
        return true;
    }

    @Override
    public Tventa getUltimoRegistro(Session session) throws Exception {
        String hql="from Tventa order by idVenta desc";
        Query query=session.createQuery(hql).setMaxResults(1);
        
        return (Tventa) query.uniqueResult();
    }
    
}
