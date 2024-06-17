package es.events.persistencia;

import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManager;

public class T0Conexion {
	//CREO EL METODO; NOTA: DESPLEGAR PARA VER QUÉ HACE EL MÉTODO
	/**
	 * Metodo para comprobar si se conecta bien a la BBDD
	 * @author David
	 * BLOQUE TRY-FINALLY: TRY, PARA VERIFICAR SI SE CONECTÓ O NO A LA BBDD; 
	 * FINALLY, SE EJECUTA INDEPENDIOENTEMENTE DE SI HAY EXCEPCIÓN EN EL TRY; SIRVE PARA CERRAR EL em EN CUALQUIER CASO Y NO HAY FUGA DE RECURSOS
	 */
	@Test
	public void comprobarConex(){
		//OBTENGO INSTANMCIA DEL EMF:
		EntityManager em = EMF.getInstance().createEntityManager();
		
		//BLOQUE TRY-FINALLY:
		try {
			if (em.isOpen()) {
				System.out.println("Conexión efectiva a la BBDD");
				
			}else {
				System.err.println("Error en la conexión a la BBDD");
			}
			
		} finally {
			//CERRAR EL EM:
			if(em.isOpen())
				em.close();
		}
			
	}
}
	
	
	
	
	

	
	


