/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.AlertaEntity;
import Entites.HistorialEntity;
import Entites.PacienteEntity;
import Persistence.PacientePersistence;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import logica.interfaces.IPaciente;

/**
 *
 * @author s.ardila13
 */
@Stateless
public class PacienteLogic implements IPaciente {
    
    @Inject
    private PacientePersistence persistence;

    @Override
    public PacienteEntity crearPaciente(PacienteEntity paciente) {
        return persistence.create(paciente);
    }

    @Override
    public PacienteEntity buscarPaciente(Long id) {
        return persistence.find(id);
    }

    @Override
    public List<PacienteEntity> darPacientes() {
        return persistence.findAll();
    }

    @Override
    public void eliminarPaciente(Long id) {
        persistence.delete(id);
    }

    @Override
    public PacienteEntity modificarPaciente(Long id, PacienteEntity paciente) {
        return persistence.update(paciente);
    }

    @Override
    public HistorialEntity modificarHistorialPaciente(Long idPaciente, HistorialEntity p) {
        return persistence.modificarHistorialPaciente(idPaciente, p);
    }

    @Override
    public List<AlertaEntity> getHistorialPorRango(Long idPaciente, Date date, Date date0) {
        return persistence.getHistorialPorRango(idPaciente, date, date0);
    }

}
