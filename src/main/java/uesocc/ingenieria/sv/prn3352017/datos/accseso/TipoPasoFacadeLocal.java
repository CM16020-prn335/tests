/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.accseso;

import java.util.List;
import javax.ejb.Local;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.TipoPaso;

/**
 *
 * @author kevin
 */
@Local
public interface TipoPasoFacadeLocal {

    void create(TipoPaso tipoPaso);

    void edit(TipoPaso tipoPaso);

    void remove(TipoPaso tipoPaso);

    TipoPaso find(Object id);

    List<TipoPaso> findAll();

    List<TipoPaso> findRange(int[] range);

    int count();
    
}
