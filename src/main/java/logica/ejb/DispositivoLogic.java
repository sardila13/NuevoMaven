/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.AlertaEntity;
import Entites.ConfiguracionEntity;
import Entites.DispositivoEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;
import java.util.Date;
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
import logica.interfaces.IDispositivo;

/**
 *
 * @author s.ardila13
 */
@Stateless
public class DispositivoLogic implements IDispositivo {

    @Inject
    private DispositivoLogic persistence;
    
    @Override
    public void crearDispositivo(DispositivoEntity dispositivo) {
        persistence.crearDispositivo(dispositivo);
    }

    @Override
    public DispositivoEntity buscarDispositivo(Long id) {
        return persistence.buscarDispositivo(id);
    }

    @Override
    public List<DispositivoEntity> darDispositivos() {
        return persistence.darDispositivos();
    }

    @Override
    public void eliminarDispositivo(Long id) {
        persistence.eliminarDispositivo(id);
    }

    @Override
    public void modificarDispositivo(Long id, DispositivoEntity paciente) {
        persistence.modificarDispositivo(id, paciente);
    }

    @Override
    public ConfiguracionEntity setConfiguracion(ConfiguracionEntity confi, Long idDispositivo) {
        return persistence.setConfiguracion(confi, idDispositivo);
    }

    @Override
    public void agregarAlerta(Long idDispositivo, AlertaEntity alerta) {
        persistence.agregarAlerta(idDispositivo, alerta);
    }
    
    
    
    
}
