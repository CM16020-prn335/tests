/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.accseso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uesocc.ingenieria.sv.prn3352017.datos.definiciones.UsuarioRolCategoria;

/**
 *
 * @author kevin
 */
@Stateless
public class UsuarioRolCategoriaFacade extends AbstractFacade<UsuarioRolCategoria> implements UsuarioRolCategoriaFacadeLocal {

    @PersistenceContext(unitName = "uesocc.ingenieria.sv.prn3352017_postsFinalEstesieselBergon_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRolCategoriaFacade() {
        super(UsuarioRolCategoria.class);
    }
    
}
