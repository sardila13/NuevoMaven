package logica.interfaces;

import Entites.AlertaEntity;
import Entites.ConfiguracionEntity;
import Entites.DispositivoEntity;
import com.sun.media.jfxmediaimpl.MediaDisposer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s.ardila13
 */
public interface IDispositivo {
    
    public void crearDispositivo(DispositivoEntity dispositivo);
    
    public DispositivoEntity buscarDispositivo(Long id);
    
    public List<DispositivoEntity> darDispositivos();
    
    public void eliminarDispositivo(Long id);
    
    public void modificarDispositivo(Long id, DispositivoEntity paciente);
    
    public ConfiguracionEntity setConfiguracion(ConfiguracionEntity confi, Long idDispositivo);

    public void agregarAlerta(Long idDispositivo, AlertaEntity alerta);

    
}
