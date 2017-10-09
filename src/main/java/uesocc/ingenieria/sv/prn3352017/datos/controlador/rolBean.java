/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import uesocc.ingenieria.sv.prn3352017.datos.accseso.RolFacadeLocal;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.Rol;

@Named
@ViewScoped
public class rolBean implements Serializable{

   public rolBean(){
       
   }
    @EJB 
    RolFacadeLocal RolFacade;
     List<Rol> listRol=new ArrayList<>();
    
    @PostConstruct
    public void init() {
       this.listRol=RolFacade.findAll();
    }
   
     public List<Rol> getListRol() {
        return listRol;
    }

    public void setListRol(List<Rol> listRol) {
        this.listRol = listRol;
    }

    public RolFacadeLocal getRolFacade() {
        return RolFacade;
    }

    public void setRolFacade(RolFacadeLocal RolFacade) {
        this.RolFacade = RolFacade;
    }
    
}
