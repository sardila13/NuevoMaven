/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entites.ConfiguracionEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author s.ardila13
 */
public class ConfiguracionPersistence {
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
    public ConfiguracionEntity find(Long id)
    {
        return em.find(ConfiguracionEntity.class, id);
    }
    
    /**
     * da todos los administradores de la base de datos
     * @return devuelve todos los administradores
     */
    public List<ConfiguracionEntity> findAll() {
        Query q = em.createQuery("select u from ConfiguracionEntity u");
        return q.getResultList();
    }
    
    /**
     * crear un administrador
     * @param config
     * @return retorna el administrador creado
     */
    public ConfiguracionEntity create (ConfiguracionEntity config)
    {
        em.persist(config);
        return config;
    }
    
    /**
     * Modificar un administrador
     * @param config administrador a modificar
     * @return el administrador modificado
     */
    public ConfiguracionEntity update (ConfiguracionEntity config)
    {
        return em.merge(config);
    }
    
    /**
     * Borrar un adminitrador dado su id
     * @param id identificador del administrador
     */
    public void delete(Long id)
    {
        ConfiguracionEntity entity = em.find(ConfiguracionEntity.class, id);
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
