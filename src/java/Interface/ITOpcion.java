/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojo.Opcion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public interface ITOpcion {
     public Opcion getByIdOpcion(Session session, Integer idOpcion) throws Exception;
    public List<Opcion> getAll(Session session) throws Exception;
    public Opcion getByCedula(Session session, String cedula) throws Exception;
    public boolean insert(Session session, Opcion opcion) throws Exception;
    public boolean update(Session session, Opcion opcion) throws Exception;
    public boolean delete(Session session,Opcion opcion) throws Exception;
}
