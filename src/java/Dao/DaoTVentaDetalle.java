/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.ITVentaDetalle;
import Pojo.Tventadetalle;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public class DaoTVentaDetalle implements ITVentaDetalle
{

    @Override
    public boolean insert(Session session, Tventadetalle tVentaDetalle) throws Exception {
        session.save(tVentaDetalle);
        
        return true;
    }
    
}
