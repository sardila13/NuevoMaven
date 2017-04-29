package logica.interfaces;

import Entites.AmbulanciaEntity;

/**
 *
 * @author Sneider Velandia G
 */
public interface IAmbulancia 
{
    public void crearAmbulancia(AmbulanciaEntity ambulancia);
    public AmbulanciaEntity buscarAmbulancia(int id);
    public AmbulanciaEntity[] darAmbulancias ();
    public void eliminarAmbulancia(int id);
        
}
