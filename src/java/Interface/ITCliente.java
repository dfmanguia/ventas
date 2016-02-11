/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Pojo.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author KevinArnold
 */
public interface ITCliente 
{
    public Cliente getByIdCliente(Session session, Integer idCliente) throws Exception;
    public List<Cliente> getAll(Session session) throws Exception;
    public Cliente getByCedula(Session session, String cedula) throws Exception;
    public boolean insert(Session session, Cliente cliente) throws Exception;
    public boolean update(Session session, Cliente cliente) throws Exception;
    public boolean delete(Session session,Cliente cliente) throws Exception;
}
