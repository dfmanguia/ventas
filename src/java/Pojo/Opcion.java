package Pojo;
// Generated feb 18, 2016 6:40:59 p.m. by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Opcion generated by hbm2java
 */
public class Opcion  implements java.io.Serializable {


     private Integer idOp;
     private Boolean ins;
     private Boolean upd;
     private Boolean del;
     private Boolean ver;
     private Set perfils = new HashSet(0);

    public Opcion() {
    }

    public Opcion(Boolean ins, Boolean upd, Boolean del, Boolean ver, Set perfils) {
       this.ins = ins;
       this.upd = upd;
       this.del = del;
       this.ver = ver;
       this.perfils = perfils;
    }
   
    public Integer getIdOp() {
        return this.idOp;
    }
    
    public void setIdOp(Integer idOp) {
        this.idOp = idOp;
    }
    public Boolean getIns() {
        return this.ins;
    }
    
    public void setIns(Boolean ins) {
        this.ins = ins;
    }
    public Boolean getUpd() {
        return this.upd;
    }
    
    public void setUpd(Boolean upd) {
        this.upd = upd;
    }
    public Boolean getDel() {
        return this.del;
    }
    
    public void setDel(Boolean del) {
        this.del = del;
    }
    public Boolean getVer() {
        return this.ver;
    }
    
    public void setVer(Boolean ver) {
        this.ver = ver;
    }
    public Set getPerfils() {
        return this.perfils;
    }
    
    public void setPerfils(Set perfils) {
        this.perfils = perfils;
    }




}


