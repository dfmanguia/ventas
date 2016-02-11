/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojo.Tventa;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public interface ITVenta {
    public boolean insert(Session session, Tventa tVenta) throws Exception;
    public Tventa getUltimoRegistro(Session session) throws Exception;
}
