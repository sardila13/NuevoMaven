/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import Entites.ConfiguracionEntity;
import Entites.ConsejoEntity;
import Entites.MedicoEntity;
import Persistence.MedicoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import logica.interfaces.IMedicoLogic;

/**
 *
 * @author Sneider Velandia G
 */
@Stateless
public class MedicoLogic implements IMedicoLogic{

    @Inject
    private MedicoPersistence persistence;
    
    @Override
    public void crearMedico(MedicoEntity medico) {
        persistence.create(medico);
    }

    @Override
    public MedicoEntity buscarMedico(Long id) {
        return persistence.find(id);
    }

    @Override
    public List<MedicoEntity> darMedicos() {
        return persistence.findAll();
    }

    @Override
    public void eliminarMedico(Long id) {
        persistence.delete(id);
    }

    @Override
    public ConfiguracionEntity configurarMarcapasos(Long id, ConfiguracionEntity cofiguracion) {
        return persistence.configurarMarcapasos(id, cofiguracion);
        
    }

    @Override
    public ConsejoEntity enviarConsejo(Long idPaciente, ConsejoEntity consejo) {
        return persistence.enviarConsejo(idPaciente, consejo);
    }


   
    
}
