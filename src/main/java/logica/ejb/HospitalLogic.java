/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.HospitalEntity;
import Persistence.HospitalPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
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
import javax.ws.rs.core.Response;
import logica.interfaces.IHospital;


/**
 *
 * @author gc.andrade10
 */
@Stateless

public class HospitalLogic implements IHospital
{
    @Inject
    private HospitalPersistence persistence;
    
    public HospitalEntity crear(HospitalEntity hospital){
        return persistence.create(hospital);
    }
}
