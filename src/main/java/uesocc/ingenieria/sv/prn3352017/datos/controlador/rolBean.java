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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped; 
import javax.inject.Named;
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
    boolean activo, panel=true;
    
       
       public rolBean(){
       }
       
      /**
       * Este metodo carga la lista inicial de datos a la DataTable al ingresar a la aplicacion
       */
     @PostConstruct
      public void init() {
      llenarLista();
      System.out.println("POSTCONSTRUCT");
    }
    
      /**
       * Invoca el metodo findAll de la clase abstractFacade que retorna una lista de registros de la base de datos,
       * posteriormente se asigna una lista propiedad de esta clase
       */
    public void llenarLista(){
         if(listRol!=null){
           this.listRol=RolFacade.findAll();
           limpiar();
                    System.out.println("LLENARLISTA");
       }else{
           this.listRol= Collections.EMPTY_LIST;
       }
    }
    
    /**
     * invoca al metodo create de la clase AbstractFacade y crea un registro en la DB
     */
      public void crear() {
            try {
                RolFacade.create(rol);
                llenarLista();
                cancelar();
                System.out.println("CREAR");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
    }
      
      /**
       * Elimina registros de la DB utilizando el metodo remove de la clase AbstractFacade
       */
       public void borrar() {
                try {
                    RolFacade.remove(rol);
                    llenarLista();
                    limpiar();
                    System.out.println("BORRAR");
                 } catch (Exception e) {
                     System.out.println("ESTO DA ERROR PAPU"+e.getMessage());
                     Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
               }
           }
       
       /**
        * Invaco al metodo edit de la clase AbstractFacade para editar un registro
        */
       public void editar(){
          try {
                RolFacade.edit(rol);
                llenarLista();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
       
       }
         
       /**
        * si el objeto rol es diferente de nulo asigna una nueva instancia a este para dejarlo vacio, oculta el panel de botones de edicion
        */
      public void limpiar(){
       rol= new Rol();
       panel=true;
          }
      
      
      public void cancelar(){
            rol.setActivo(false);
            rol.setDescripcion(null);
            rol.setIdRol(null);
            rol.setNombre(null);
            System.out.println("CANCELAR");
            panel=true;
         }
      
    
         
       /**
        * evalua si la propiedad "activo" es true o false para filtrar datos por medio del metodo ObtenerUtilizados
        */
        public void chkCambio(){
            if(activo == true){
                this.listRol = RolFacade.obtenerUtilizados();
            }else{
                llenarLista();
          }
        }
        
        /**
         * Recice un evente de tipo SelectEvent, asigna los valores del objeto recivido a las propiedades del objeto rol
         * @param event 
         */
    public void onRowSelect(SelectEvent event) {
        rol = (Rol) event.getObject();
        panel=false;

    }
 
    public void onRowUnselect(UnselectEvent event) {
        cancelar();
        panel=true;
        
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

    public boolean isPanel() {
        return panel;
    }

    public void setPanel(boolean panel) {
        this.panel = panel;
    }



   
     
}
