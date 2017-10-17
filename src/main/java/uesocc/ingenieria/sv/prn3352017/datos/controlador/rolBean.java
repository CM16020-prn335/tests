/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
package uesocc.ingenieria.sv.prn3352017.datos.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import uesocc.ingenieria.sv.prn3352017.datos.accseso.RolFacadeLocal;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.Rol;

@Named(value = "rolBean")
@ViewScoped
public class rolBean implements Serializable{
   
   
   
    @EJB 
    RolFacadeLocal RolFacade;
    Rol rol = new Rol();
     List<Rol> listRol=new ArrayList<>();
     boolean activo;
       
       public rolBean(){}

     @PostConstruct
    public void init() {
       if(listRol!=null){
           this.listRol=RolFacade.findAll();
       }else{
           this.listRol= Collections.EMPTY_LIST;
       }
    }
    
      public void crear() {
            try {
                RolFacade.create(rol);
                init();
                showMessage("Datos ingresado correctamente.");
                rol = new Rol();
            } catch (Exception e) {
                System.out.println("Error: " + e);
                showMessage("Error al ingresar los datos.");
            }
    }
      
      public void limpiar(){
       rol = new Rol();
      }
         public void showMessage(String mensaje){
               FacesContext context =FacesContext.getCurrentInstance();
               context.addMessage(null, new FacesMessage(mensaje));
           }
       
        public void chkCambio(){
            if(activo == true){
                this.listRol = RolFacade.obtenerUtilizados();
                System.out.println("Funciona");
            }else{
                init();
                System.out.println("No funciona");
        }
        }
        
    public void onRowSelect(SelectEvent event) {
        rol = (Rol) event.getObject();
    }
 /*
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
*/
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
     
}
