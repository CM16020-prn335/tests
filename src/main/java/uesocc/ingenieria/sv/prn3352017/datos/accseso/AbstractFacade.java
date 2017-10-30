/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.sv.prn3352017.datos.accseso;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author kevin
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
       
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        try {
             EntityManager em = getEntityManager();
              if (em!=null && entity!=null) {
                em.persist(entity);
                 showMessage("Registro creado correctamente.");
                System.out.println("CREATE");
            }
        } catch (Exception e) {
            showMessage("Error al crear registro.");
            System.out.println("ERROR CREATE");
            System.out.println(e);
        }
      
    }
    
    public void remove(T entity) {
      
          try {
              EntityManager em = getEntityManager();
               if (em!=null && entity!=null) {
              em.remove(em.merge(entity));
              System.out.println("REMOVE");
              showMessage("Registro eliminado correctamente.");
               }
        } catch (Exception e) {
            showMessage("Error al eliminar registro");
            System.out.println("ERROR EN REMOVE"+e);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
      }

    public void edit(T entity) {
         try {
            EntityManager em = getEntityManager();
             if (em!=null && entity!=null) {
                em.merge(entity);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
       
   
    
        public void showMessage(String mensaje){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", mensaje));
    
        }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
    
}
