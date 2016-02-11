/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojo.Perfil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diegg
 */
public interface ITPerfil {
   public Perfil getByIdPerfil(Session session, Integer idPerfil) throws Exception;
    public List<Perfil> getAll(Session session) throws Exception;
    public Perfil getByCedula(Session session, String cedula) throws Exception;
    public boolean insert(Session session, Perfil perfil) throws Exception;
    public boolean update(Session session, Perfil perfil) throws Exception;
    public boolean delete(Session session,Perfil perfil) throws Exception; 
}
