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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        public List<Rol> obtenerUtilizados() {
        List salida;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uesocc.ingenieria.sv.prn3352017_postsFinalEstesieselBergon_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query c = em.createNamedQuery("Rol.noUtilizados");
        salida = c.getResultList();
        
        if(salida != null){
        return salida;
        }else{
            return Collections.EMPTY_LIST;
        }
    }
        public void chkCambio(){
            if(activo == true){
                this.listRol = obtenerUtilizados();
                System.out.println("Funciona");
            }else{
                init();
                System.out.println("No funciona");
        }
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

   
     
}
