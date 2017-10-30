/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.controlador;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import uesocc.ingenieria.sv.prn3352017.datos.accseso.InterfaceFacade;

/**
 *
 * @author kevin
 */
public abstract class AbstractManagedBean<T> implements Serializable {
    
    public void AbstractManagedBean( ) {
         this.fl = getFacadeLocal();
         this.entity = getEntity();
    }
    
     InterfaceFacade fl;
     T entity;
    protected List<T> listaRegistros;
    
    protected abstract InterfaceFacade<T> getFacadeLocal();
    protected abstract T getEntity();

    /**
     * Este metodo sirve para crear un nuevo un registro
     *
     */
    public void crear() {

        if (fl != null && entity != null) {
            try {
                fl.create(entity);
                llenarLista();
                System.out.println("CREAR");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    /**
     * Este metodo sirve para editar un registro
     *
     */
    public void editar() {
        if (fl != null && entity != null) {
            try {
                fl.edit(entity);
                llenarLista();
                System.out.println("EDITAR");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    /**
     * Este metodo sirve para eliminar un registro
     *
     */
    public void eliminar() {
        if (fl != null && entity != null) {
            try {
                fl.remove(entity);
                llenarLista();
                System.out.println("ELIMINAR");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    /**
     * Invoca el metodo findAll de la clase abstractFacade que retorna una lista
     * de registros de la base de datos, posteriormente se asigna una lista
     * propiedad de esta clase
     */
    public void llenarLista() {
        if (fl.findAll() != null) {
            this.listaRegistros = fl.findAll();
        } else {
            this.listaRegistros = Collections.EMPTY_LIST;
        }
    }

}
