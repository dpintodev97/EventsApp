package es.events.persistencia;

import jakarta.persistence.EntityManager;

public class T0Conexion {
	//OBTENGO INSTANCIA DEL EMF:
	EntityManager em = EMF.getInstance().createEntityManager();
	

}
