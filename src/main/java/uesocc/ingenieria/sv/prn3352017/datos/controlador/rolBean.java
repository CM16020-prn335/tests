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
import org.primefaces.component.panel.Panel;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
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
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    
       
       public rolBean(){
       }

     @PostConstruct
    public void init() {
       if(listRol!=null){
           this.listRol=RolFacade.findAll();
       }else{
           this.listRol= Collections.EMPTY_LIST;
       }
       panel2.setVisible(false);
    }
    
      public void crear() {
            try {
                RolFacade.create(rol);
                
               // showMessage("Registro ingresado correctamente.");
                limpiar();
            } catch (Exception e) {
                System.out.println("Error: " + e);
                showMessage("Error al ingresar los datos.");
            }
    }
       public void borrar(){
          try {
              RolFacade.remove(rol);
              init();
              showMessage("Registro borrado exitosamente");
              addMessage("Registro borrado exitosamente");
          } catch (Exception e) {
              showMessage("Error al borrar registro");
          }
      }
       
       public void editar(){
          try {
                RolFacade.edit(rol);
                init();
               // showMessage("Registro ingresado correctamente.");
                
            } catch (Exception e) {
                System.out.println("Error: " + e);
                showMessage("Error al ingresar los datos.");
            }
       
       }
         
      public void limpiar(){
        if (rol!=null) {
       rol=null;
       panel1.setVisible(true);
       panel2.setVisible(false);
          }
      }
      
      public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.FACES_MESSAGES, summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
         public void showMessage(String mensaje){
               FacesContext context =FacesContext.getCurrentInstance();
               context.addMessage(null, new FacesMessage(mensaje));
         }
       
        public void chkCambio(){
            if(activo == true){
                this.listRol = RolFacade.obtenerUtilizados();
            }else{
                init();
        }
        }
        
    public void onRowSelect(SelectEvent event) {
        rol = (Rol) event.getObject();
        panel1.setVisible(false);
        panel2.setVisible(true);

    }
 
    public void onRowUnselect(UnselectEvent event) {
        
        
    }

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

    public Panel getPanel1() {
        return panel1;
    }

    public void setPanel1(Panel panel1) {
        this.panel1 = panel1;
    }

    public Panel getPanel2() {
        return panel2;
    }

    public void setPanel2(Panel panel2) {
        this.panel2 = panel2;
    }

   
     
}
