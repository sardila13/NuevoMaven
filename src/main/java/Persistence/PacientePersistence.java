/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Entites.AlertaEntity;
import Entites.DispositivoEntity;
import Entites.HistorialEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author s.ardila13
 */
public class PacientePersistence {
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
    public PacienteEntity find(Long id)
    {
        return em.find(PacienteEntity.class, id);
    }
    
    /**
     * da todos los administradores de la base de datos
     * @return devuelve todos los administradores
     */
    public List<PacienteEntity> findAll() {
        Query q = em.createQuery("select u from PacienteEntity u");
        return q.getResultList();
    }
    
    /**
     * crear un administrador
     * @param paciente
     * @return retorna el administrador creado
     */
    public PacienteEntity create (PacienteEntity paciente)
    {
        em.persist(paciente);
        return paciente;
    }
    
    /**
     * Modificar un administrador
     * @param paciente administrador a modificar
     * @return el administrador modificado
     */
    public PacienteEntity update (PacienteEntity paciente)
    {
        return em.merge(paciente);
    }
    
    /**
     * Borrar un adminitrador dado su id
     * @param id identificador del administrador
     */
    public void delete(Long id)
    {
        PacienteEntity entity = em.find(PacienteEntity.class, id);
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
    
    public HistorialEntity modificarHistorialPaciente(Long idPaciente, HistorialEntity historial){
        PacienteEntity paciente = em.find(PacienteEntity.class, idPaciente);
        paciente.setHistorial(historial);
        em.merge(paciente);
        return paciente.getHistorial();
    }

    public List<AlertaEntity> getHistorialPorRango(Long idPaciente, Date date, Date date0) {
        ArrayList<AlertaEntity> r = new ArrayList<>();
        
        PacienteEntity p= em.find(PacienteEntity.class,idPaciente);
        DispositivoEntity d = em.find(DispositivoEntity.class, p.getDispositivo().getId());
        //Funciona historial
        for (int i =0; i<d.getAlertas().size();i++)
        {
            AlertaEntity actual = d.getAlertas().get(i);
            
            if(actual.getFecha().after(date) && actual.getFecha().before(date0))
            {
                r.add(actual);
            }
        }
        return r;
    }
}
