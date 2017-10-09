/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.accseso;

import java.util.List;
import javax.ejb.Local;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.TipoSeccion;

/**
 *
 * @author kevin
 */
@Local
public interface TipoSeccionFacadeLocal {

    void create(TipoSeccion tipoSeccion);

    void edit(TipoSeccion tipoSeccion);

    void remove(TipoSeccion tipoSeccion);

    TipoSeccion find(Object id);

    List<TipoSeccion> findAll();

    List<TipoSeccion> findRange(int[] range);

    int count();
    
}
