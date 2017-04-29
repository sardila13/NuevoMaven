/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entites.AlertaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author s.ardila13
 */
public class AlertaPersistence {
    private static final Logger LOGGER = Logger.getLogger(AlertaPersistence.class.getName());
    
    // "bolsa" donde estaran los obj1, obj2.... (Administrador) que son parte de la base de datos en forma de fila
    @PersistenceContext(unitName = "Derby")
    protected EntityManager em;
    
    /// CRUD ///
    
    /**
     * encontrar alerta por un id
     * @param id identificador del administrador
     * @return administrador con el id dado.
     */
    public AlertaEntity find(Long id)
    {
        return em.find(AlertaEntity.class, id);
    }
    
    /**
     * da todos los administradores de la base de datos
     * @return devuelve todos los administradores
     */
    public List<AlertaEntity> findAll() {
        Query q = em.createQuery("select u from AlertaEntity u");
        return q.getResultList();
    }
    
    /**
     * crear un administrador
     * @param alerta
     * @return retorna el administrador creado
     */
    public AlertaEntity create (AlertaEntity alerta)
    {
        em.persist(alerta);
        return alerta;
    }
    
    /**
     * Modificar un administrador
     * @param alerta administrador a modificar
     * @return el administrador modificado
     */
    public AlertaEntity update (AlertaEntity alerta)
    {
        return em.merge(alerta);
    }
    
    /**
     * Borrar un adminitrador dado su id
     * @param id identificador del administrador
     */
    public void delete(Long id)
    {
        AlertaEntity entity = em.find(AlertaEntity.class, id);
        em.remove(entity);
    }
        
    public void truncate()
    {
        List a = findAll();
        for (Object object : a) 
        {
            em.remove(object);
        }
    }
}
