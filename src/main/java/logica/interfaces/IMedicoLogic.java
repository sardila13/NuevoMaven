/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;
import Entites.ConfiguracionEntity;
import Entites.ConsejoEntity;
import Entites.MedicoEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sneider Velandia G
 */
public interface IMedicoLogic 
{
    public void crearMedico(MedicoEntity medico);
    public MedicoEntity buscarMedico(Long id);
    public List<MedicoEntity>darMedicos();
    public void eliminarMedico(Long id);
    public ConfiguracionEntity configurarMarcapasos(Long id, ConfiguracionEntity cofiguracion);
    public ConsejoEntity enviarConsejo(Long idPaciente, ConsejoEntity consejo);
    
}
