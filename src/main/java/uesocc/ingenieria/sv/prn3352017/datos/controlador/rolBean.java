/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import uesocc.ingenieria.sv.prn3352017.datos.accseso.InterfaceFacade;
import uesocc.ingenieria.sv.prn3352017.datos.accseso.RolFacadeLocal;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.Rol;

@Named(value = "rolBean")
@ViewScoped
public class rolBean extends AbstractManagedBean<Rol> implements Serializable {

    @EJB
    RolFacadeLocal RolFacade;
    Rol rol= new Rol();
    boolean activo, panel = true;
    
    public rolBean() {
    }
   
    /**
     * Este metodo carga la lista inicial de datos a la DataTable al ingresar a
     * la aplicacion
     */
    @PostConstruct
    public void init() {
        super.AbstractManagedBean();
        llenarLista();
        System.out.println("POSTCONSTRUCT");
    }

    /**
     * invoca al metodo create de la clase AbstractFacade y crea un registro en
     * la DB
     */
    @Override
    public void crear() {
        super.AbstractManagedBean();
        super.crear();
        limpiar();
    }

    /**
     * Elimina registros de la DB utilizando el metodo remove de la clase
     * AbstractFacade
     */
    @Override
    public void eliminar() {
        super.AbstractManagedBean();
        super.eliminar();
        limpiar();
    }

    /**
     * Invaco al metodo edit de la clase AbstractFacade para editar un registro
     */
    @Override
    public void editar() {
        super.AbstractManagedBean();
        super.editar();
        limpiar();
    }

    /**
     * si el objeto rol es diferente de nulo asigna una nueva instancia a este
     * para dejarlo vacio, oculta el panel de botones de edicion
     */
    public void limpiar() {
        rol.setActivo(false);
        rol.setDescripcion(null);
        rol.setIdRol(null);
        rol.setNombre(null);
        System.out.println("LIMPIAR");
        panel = true;
    }

    /**
     * evalua si la propiedad "activo" es true o false para filtrar datos por
     * medio del metodo ObtenerUtilizados
     */
//    public void chkCambio() {
//        if (activo == true) {
//            this.listRol = RolFacade.obtenerUtilizados();
//        } else {
//            llenarLista();
//        }
//    }

    /**
     * Recice un evente de tipo SelectEvent, asigna los valores del objeto
     * recivido a las propiedades del objeto rol
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        rol = (Rol) event.getObject();
        panel = false;

    }

    public void onRowUnselect(UnselectEvent event) {
        limpiar();
        panel = true;

    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public  RolFacadeLocal getRolFacade() {
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

    public List<Rol> getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List<Rol> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }
    
    @Override
    protected InterfaceFacade<Rol> getFacadeLocal() {
        return RolFacade;
    }

    @Override
    protected Rol getEntity() {
        return rol;
    }

}
