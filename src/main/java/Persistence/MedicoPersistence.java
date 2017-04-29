/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entites.ConfiguracionEntity;
import Entites.ConsejoEntity;
import Entites.DispositivoEntity;
import Entites.MedicoEntity;
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
public class MedicoPersistence {
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
    public MedicoEntity find(Long id)
    {
        return em.find(MedicoEntity.class, id);
    }
    
    /**
     * da todos los administradores de la base de datos
     * @return devuelve todos los administradores
     */
    public List<MedicoEntity> findAll() {
        Query q = em.createQuery("select u from MedicoEntity u");
        return q.getResultList();
    }
    
    /**
     * crear un administrador
     * @param medico
     * @return retorna el administrador creado
     */
    public MedicoEntity create (MedicoEntity medico)
    {
        em.persist(medico);
        return medico;
    }
    
    /**
     * Modificar un administrador
     * @param medico administrador a modificar
     * @return el administrador modificado
     */
    public MedicoEntity update (MedicoEntity medico)
    {
        return em.merge(medico);
    }
    
    /**
     * Borrar un adminitrador dado su id
     * @param id identificador del administrador
     */
    public void delete(Long id)
    {
        MedicoEntity entity = em.find(MedicoEntity.class, id);
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
    
    public ConfiguracionEntity configurarMarcapasos(Long id, ConfiguracionEntity cofiguracion){
        DispositivoEntity dispositivo = em.find(DispositivoEntity.class, id);
        dispositivo.setConfiguracion(cofiguracion);
        em.merge(dispositivo);
        return dispositivo.getConfiguracion();
    }
    
    public ConsejoEntity enviarConsejo(long idPaciente, ConsejoEntity consejo){
        PacienteEntity paciente = em.find(PacienteEntity.class, idPaciente);
        paciente.agregarConsejo(consejo);
        em.merge(paciente);
        return consejo;
    }
}
