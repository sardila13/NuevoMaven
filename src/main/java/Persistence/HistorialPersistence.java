/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entites.HistorialEntity;
import Entites.PacienteEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author s.ardila13
 */
public class HistorialPersistence {
        private static final Logger LOGGER = Logger.getLogger(AmbulanciaPersistence.class.getName());
    
    // "bolsa" donde estaran los obj1, obj2.... (Administrador) que son parte de la base de datos en forma de fila
    @PersistenceContext(unitName = "Derby")
    protected EntityManager em;
    
    /// CRUD ///
    
    /**
     * encontrar alerta por un id
     * @param id identificador del administrador
     * @return administrador con el id dado.
     */
    public HistorialEntity find(Long id)
    {
        return em.find(HistorialEntity.class, id);
    }
    
    /**
     * da todos los administradores de la base de datos
     * @return devuelve todos los administradores
     */
    public List<HistorialEntity> findAll() {
        Query q = em.createQuery("select u from HistorialEntity u");
        return q.getResultList();
    }
    
    /**
     * crear un administrador
     * @param historial
     * @return retorna el administrador creado
     */
    public HistorialEntity create (HistorialEntity historial)
    {
        em.persist(historial);
        return historial;
    }
    
    /**
     * Modificar un administrador
     * @param historial administrador a modificar
     * @return el administrador modificado
     */
    public HistorialEntity update (HistorialEntity historial)
    {
        return em.merge(historial);
    }
    
    /**
     * Borrar un adminitrador dado su id
     * @param id identificador del administrador
     */
    public void delete(Long id)
    {
        HistorialEntity entity = em.find(HistorialEntity.class, id);
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