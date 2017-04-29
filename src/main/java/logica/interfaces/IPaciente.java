/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import Entites.AlertaEntity;
import Entites.HistorialEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author s.ardila13
 */
public interface IPaciente {
    
    public PacienteEntity crearPaciente(PacienteEntity paciente);
    
    public PacienteEntity buscarPaciente(Long id);
    
    public List<PacienteEntity> darPacientes();
    
    public void eliminarPaciente(Long id);
    
    public PacienteEntity modificarPaciente(Long id, PacienteEntity paciente);

    public HistorialEntity modificarHistorialPaciente(Long idPaciente, HistorialEntity p);

    public List<AlertaEntity> getHistorialPorRango(Long idPaciente, Date date, Date date0);
}
