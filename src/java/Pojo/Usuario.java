package Pojo;
// Generated feb 18, 2016 6:40:59 p.m. by Hibernate Tools 4.3.1



/**
 * Usuario generated by dm
 */
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private Perfil perfil;
     private Personal personal;
     private String username;
     private String password;

    public Usuario() {
        this.perfil=new Perfil();
        this.personal=new Personal();
 
    }
    public Usuario(Perfil perfil, Personal personal, String username, String password) {
       this.perfil = perfil;
       this.personal = personal;
       this.username = username;
       this.password = password;
    }

    public Usuario(Integer id, Perfil perfil, Personal personal, String username, String password) {
        this.id = id;
        this.perfil = perfil;
        this.personal = personal;
        this.username = username;
        this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


