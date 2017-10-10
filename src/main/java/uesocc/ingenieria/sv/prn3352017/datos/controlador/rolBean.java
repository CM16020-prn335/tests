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
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.Table;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import uesocc.ingenieria.sv.prn3352017.datos.accseso.RolFacadeLocal;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.Rol;

@Named
@RequestScoped
public class rolBean implements Serializable{
    
    private DataTable table;
    private SelectBooleanCheckbox chk;
    private Rol rol= new Rol
    
    
    
   public rolBean(){}
   
    @EJB 
    RolFacadeLocal RolFacade;
     List<Rol> listRol=new ArrayList<>();

     @PostConstruct
    public void init() {
       this.listRol=RolFacade.findAll();
       
    }
   
  public void change(){
      if (chk.isSelected()) {
          listRol.clear();
          listRol.add(e)
          FacesContext fc;
          table.setFilterMetadata(listRol);
      }
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

    public DataTable getTable() {
        return table;
    }

    public void setTable(DataTable table) {
        this.table = table;
    }

    public SelectBooleanCheckbox getChk() {
        return chk;
    }

    public void setChk(SelectBooleanCheckbox chk) {
        this.chk = chk;
    }

     
}
