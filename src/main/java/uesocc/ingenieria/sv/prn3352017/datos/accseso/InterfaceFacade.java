/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.accseso;

import java.util.List;

/**
 *
 * @author kevin
 * @param <T>
 */
public interface InterfaceFacade<T> {
    
    void create(T rol);

    void edit(T rol);

    void remove(T rol);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
}
