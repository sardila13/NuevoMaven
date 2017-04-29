package logica.ejb;
import Entites.AlertaEntity;
import Persistence.AlertaPersistence;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import logica.interfaces.IAlertaLogic;
/**
 *
 * @author ba.bohorquez10
 */
@Stateless
public class AlertaLogic implements IAlertaLogic
{
    //private AlertaMock persistence;
    @Inject
    private AlertaPersistence persistence;
    
    @Override
    public List<AlertaEntity> darAlertas() {
        return persistence.findAll();
    }
        

}
