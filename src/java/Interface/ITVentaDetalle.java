/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojo.Tventadetalle;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public interface ITVentaDetalle {
    public boolean insert(Session session, Tventadetalle tVentaDetalle) throws Exception;
}
